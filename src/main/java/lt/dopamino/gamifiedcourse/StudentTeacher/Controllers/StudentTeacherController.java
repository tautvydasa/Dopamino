/**
 * @(#) StudentTeacherController.java
 */

package lt.dopamino.gamifiedcourse.StudentTeacher.Controllers;

import lt.dopamino.gamifiedcourse.Model.*;
import lt.dopamino.gamifiedcourse.Model.Repository.*;
import java.util.List;

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


    private final StudentCourseRepository studentCourseRepository;

    private final CourseSectionRepository courseSectionRepository;

    private final QuestionRepository questionRepository;

    private final TeacherRepository teacherRepository;

    @Autowired
    public StudentTeacherController(StudentRepository studentRepository, PostRepository postRepository, CourseRepository courseRepository, CommentRepository commentRepository, TeacherRepository teacherRepository, StudentCourseRepository studentCourseRepository, CourseSectionRepository courseSectionRepository, QuestionRepository questionRepository) {

        this.studentRepository = studentRepository;
        this.postRepository = postRepository;
        this.courseRepository = courseRepository;
        this.commentRepository = commentRepository;

        this.studentCourseRepository = studentCourseRepository;
        this.courseSectionRepository = courseSectionRepository;
        this.questionRepository = questionRepository;

        this.teacherRepository = teacherRepository;

    }

    @GetMapping
    public String openMainPage() {
        return "Teacher/Views/StudentTeacherMainPage";
    }

    @GetMapping(value = "/courses/{id}/{id2}/task")
    public String openCourseTest(Model model, @PathVariable("id") Integer id, @PathVariable("id2") Integer id2) {
        model.addAttribute("allQuestions", questionRepository.getQuestionsById(id2));
        return "Teacher/Views/CourseSectionTestPage";
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
        model.addAttribute("studentCourses", studentCourseRepository.getStudentCourseById(student.getId()));
        return "Teacher/Views/PurchasedCoursesPage";
    }

    @GetMapping("/created_courses")
    public String showCreatedCourses(Model model) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherRepository.getTeacherByStudentId(student.getId());
        model.addAttribute("teacher", teacher);
        model.addAttribute("allCreatedCourses", courseRepository.findAllByTeacherId(teacher.getId()));
        return "Teacher/Views/CreatedCoursesPage";
    }

    @GetMapping("/create_edit_course/{id}")
    public String showCreateCourse(Model model, @PathVariable("id") Integer id)
    {
        model.addAttribute("course", new Course());
        model.addAttribute("teacher", teacherRepository.getTeacherById(id));
        return "Teacher/Views/CreateEditCoursePage";
    }

    @GetMapping(value = "/created_course_submitted")
    public String submitCourse(Model model, @RequestParam String name, @RequestParam String description)
    {
        java.util.Date date = new java.util.Date();
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherRepository.getTeacherByStudentId(student.getId());
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setDate(date);
        course.setPrice(12);
        course.setTeacher(teacher);
        course.setVoteSum(5);
        course.setVisible(true);
        course.setVotersCount(5);
        courseRepository.saveAndFlush(course);
        return "redirect:/student_teacher/created_courses/";
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

    @GetMapping(value = "/courses/{id}")
    public String openCourse(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("course", courseRepository.findById(id).get());
        model.addAttribute("allSections", courseSectionRepository.getCourseSectionsById(id));
        return "Teacher/Views/CoursePage";
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
