package lt.dopamino.gamifiedcourse.User.Controllers;

import lt.dopamino.gamifiedcourse.Model.*;
import lt.dopamino.gamifiedcourse.Model.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public UserController(CourseRepository courseRepository, StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, PostRepository postRepository, CommentRepository commentRepository) {

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/courses")
    public String openCourses(Model model) {
        model.addAttribute("allCourses", courseRepository.findAll());
        return "Teacher/Views/CoursesPage";
    }

    @GetMapping(value = "/courses/{id}")
    public String showPosts(Model model, @PathVariable("id") Integer id) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("student", student);
        model.addAttribute("course", courseRepository.getCourseById(id));
        return "Teacher/Views/CourseInfoPage";
    }

    @GetMapping(value = "/buy/{id}/{userId}")
    public String buyCourse(Model model, @PathVariable("id") Integer id, @PathVariable("userId") Integer userId) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (courseRepository.getCoursePriceById(id) <= studentRepository.getStudentPointsById(userId) && userId == student.getId()) {
            Course kursas = courseRepository.findById(id).get();
            Student studentas = studentRepository.findById(student.getId()).get();
            StudentCourse naujas = new StudentCourse();
            //naujas.setEvaluation(2.0);
            //naujas.setEvaluated(false);
            //naujas.setProgress(20.0);
            naujas.setCourse(kursas);
            naujas.setStudent(studentas);
            studentCourseRepository.saveAndFlush(naujas);
            return "pavyko.html";
        }
        return "nepavyko.html";
    }

    @GetMapping(value = "/courses_forum/{id}")
    public String showForumPosts(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("course", courseRepository.findById(id).get());
        model.addAttribute("allPosts", postRepository.getPostsById(id));
        return "Teacher/Views/CourseForumPage";
    }

    @GetMapping(value = "/courses_forum/{id}/{id2}")
    public String showPost(Model model, @PathVariable("id") Integer id, @PathVariable("id2") Integer id2) {
        model.addAttribute("course", courseRepository.findById(id).get());
        model.addAttribute("post", postRepository.findById(id2).get());
        model.addAttribute("allComments", commentRepository.getCommentsById(id2));
        return "Teacher/Views/PostPage";
    }

    @GetMapping(value = "/courses_forum/{id}/{id2}/delete")
    public String deletePost(@PathVariable("id") Integer courseId, @PathVariable("id2") Integer postId) {
        postRepository.deleteById(postId);
        return "redirect:/user/courses_forum/" + courseId;
    }

    @GetMapping(value = "/courses_forum/{id}/{id2}/write_comment")
    public String writeComment(Model model, @PathVariable("id") Integer courseId, @PathVariable("id2") Integer postId) {
        model.addAttribute("course", courseRepository.findById(courseId).get());
        model.addAttribute("post", postRepository.findById(postId).get());
        model.addAttribute("comment", new Comment());
        return "Teacher/Views/WriteCommentPage";
    }

    @GetMapping("/courses_forum")
    public String openCoursesForum(Model model) {
        model.addAttribute("allCourses", courseRepository.findAll());
        return "Teacher/Views/CoursesForumPage";
    }

    @GetMapping(value = "/courses_forum/{id}/{id2}/insert_comment")
    public String insertComment(Model model, @PathVariable("id") Integer courseId, @PathVariable("id2") Integer postId, @RequestParam String text) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("course", courseRepository.findById(courseId).get());
        model.addAttribute("post", postRepository.findById(postId).get());
        java.util.Date date = new java.util.Date();
        Comment comment = new Comment();
        Student stud = studentRepository.findById(student.getId()).get();
        Post post = postRepository.findById(postId).get();
        comment.setDate(date);
        comment.setText(text);
        comment.setStudent(stud);
        comment.setPost(post);
        commentRepository.saveAndFlush(comment);
        return "redirect:/user/courses_forum/" + courseId + '/' + postId;
    }

    @GetMapping(value = "/courses_forum/{id}/create_post")
    public String createPost(Model model, @PathVariable("id") Integer courseId) {
        model.addAttribute("course", courseRepository.findById(courseId).get());
        model.addAttribute("post", new Post());
        return "Teacher/Views/PostCreatePage";
    }

    @GetMapping(value = "/courses_forum/{id}/insert_post")
    public String insertPost(@PathVariable("id") Integer courseId, @RequestParam String name, @RequestParam String description) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        java.util.Date date = new java.util.Date();
        Post post = new Post();
        Course course = courseRepository.findById(courseId).get();
        Student stud = studentRepository.findById(student.getId()).get();
        post.setDate(date);
        post.setName(name);
        post.setDescription(description);
        post.setCourse(course);
        post.setStudent(stud);
        postRepository.saveAndFlush(post);
        return "redirect:/user/courses_forum/" + courseId;
    }

    @GetMapping(value = "/courses_forum/{id}/{id2}/edit")
    public String editPost(Model model, @PathVariable("id") Integer courseId, @PathVariable("id2") Integer postId) {
        model.addAttribute("course", courseRepository.findById(courseId).get());
        model.addAttribute("post", postRepository.findById(postId).get());
        return "Teacher/Views/PostEditPage";
    }

    @GetMapping(value = "/courses_forum/{id}/{id2}/update_post")
    public String updatePost(Model model, @Valid Post post, @PathVariable("id") Integer courseId, @RequestParam String name, @RequestParam String description) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        java.util.Date date = new java.util.Date();
        Course course = courseRepository.findById(courseId).get();
        Student stud = studentRepository.findById(student.getId()).get();
        post.setDate(date);
        post.setName(name);
        post.setDescription(description);
        post.setCourse(course);
        post.setStudent(stud);
        postRepository.save(post);
        return "redirect:/user/courses_forum/" + courseId;
    }

    public void deletePost() {

    }

    public void logout() {

    }

    public void openFilter() {

    }

    public void openSearch() {

    }

    public void submitSearch() {

    }

    public void validateSearchData() {

    }

    public void buyCourse() {

    }

    public void validatePurchase() {

    }

    public void openCourse() {

    }

    public void openCourses() {

    }

    public void openLogin() {

    }

    public void submitLogin() {

    }

    public void validateLogin() {

    }

    public void validatePermissions() {

    }

    public void editPost() {

    }

    public void submitEdit1() {

    }

    public void openRegister() {

    }

    public void submitRegister() {

    }

    public void validateRegisterData() {

    }

    public void createPost() {

    }

    public void submitPost() {

    }

    public void editProfile() {

    }

    public void submitEdit() {

    }

    public void validateEdit() {

    }

    public void openForum() {

    }

    public void selectCourse() {

    }

    public void openPost() {

    }

    public void openWriteComment() {

    }

    public void submitComment() {

    }

    public void submitFilter() {

    }

    public void openFAQ() {

    }


}
