/**
 * @(#) StudentTeacherController.java
 */

package lt.dopamino.gamifiedcourse.StudentTeacher.Controllers;

import lt.dopamino.gamifiedcourse.Model.Comment;
import lt.dopamino.gamifiedcourse.Model.Post;
import lt.dopamino.gamifiedcourse.Model.Repository.CommentRepository;
import lt.dopamino.gamifiedcourse.Model.Repository.CourseRepository;
import lt.dopamino.gamifiedcourse.Model.Repository.PostRepository;
import lt.dopamino.gamifiedcourse.Model.Repository.StudentRepository;
import lt.dopamino.gamifiedcourse.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student_teacher")
public class StudentTeacherController {

    private final StudentRepository studentRepository;

    private final PostRepository postRepository;

    private final CourseRepository courseRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public StudentTeacherController(StudentRepository studentRepository, PostRepository postRepository, CourseRepository courseRepository, CommentRepository commentRepository) {
        this.studentRepository = studentRepository;
        this.postRepository = postRepository;
        this.courseRepository = courseRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public String openMainPage() {
        return "Teacher/Views/StudentTeacherMainPage";
    }

    public void openCourseTest() {

    }

    public void submitAnswer() {

    }

    public void checkAnswer() {

    }

    public void calculateResults() {

    }

    @GetMapping("/purchased_courses")
    public String openPurchasedCourses(Model model) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("student", student);
        return "Teacher/Views/PurchasedCoursesPage";
    }

    @GetMapping("/created_courses")
    public String openCreatedCourses(Model model) {
        return "Teacher/Views/CreatedCoursesPage";
    }

    @GetMapping("/courses")
    public String openCourses(Model model) {
        return "Teacher/Views/CoursesPage";
    }

    @GetMapping("/courses_forum")
    public String openCoursesForum(Model model) {
        model.addAttribute("allCourses", courseRepository.findAll());
        return "Teacher/Views/CoursesForumPage";
    }

    @GetMapping(value = "/courses_forum/{id}")
    public String showPosts(Model model, @PathVariable("id") Integer id) {
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

    @GetMapping("/courses_forum/{id}/{id2}/write_comment")
    public String writeComment(Model model, @PathVariable("id") Integer id, @PathVariable("id2") Integer id2) {
        model.addAttribute("course", courseRepository.findById(id).get());
        model.addAttribute("post", postRepository.findById(id2).get());
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("comment", new Comment());
        return "Teacher/Views/WriteCommentPage";
    }

    @GetMapping(value = "/courses_forum/{id}/delete/{id2}")
    public String deletePost(Model model, @PathVariable("id2") Integer id2) {
        System.out.println(id2);
        System.out.println("test");
        return "redirect:/courses_forum/{id}";
    }

    public void submitRate() {

    }

    public void openCourse() {

    }

    public void openCourseLeaderboard() {

    }

    public void openCreatedCourses() {

    }

    public void openCreateCourse() {

    }

    public void addNewSection() {

    }

    public void submitCourse() {

    }

    public void validateCourse() {

    }

    public void openEditCourse() {

    }

    public void deleteCourse() {

    }

    public void submitDelete() {

    }

    public void addQuestion() {

    }

    public void addAnswer() {

    }

    public void openRequest() {

    }

    public void submitRequest() {

    }

    public void validateRequest() {

    }

    public void validateStudent() {

    }

    public void openPointsShop() {

    }

    public void submitPointsPurchase() {

    }

    public void checkPointsPurchase() {

    }

    public void submitPayment() {

    }

    public void checkStatus() {

    }

    public void showUserReport() {

    }

    public void submitReport() {

    }

    public void validateUserExists() {

    }

    public void checkCourseRating() {

    }

    public void calculatePoints() {

    }

    public void submitPoints() {

    }


}
