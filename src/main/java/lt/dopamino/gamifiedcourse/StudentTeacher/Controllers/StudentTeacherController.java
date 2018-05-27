/**
 * @(#) StudentTeacherController.java
 */

package lt.dopamino.gamifiedcourse.StudentTeacher.Controllers;

import lt.dopamino.gamifiedcourse.Model.*;
import lt.dopamino.gamifiedcourse.Model.Repository.*;

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

    @GetMapping(value = "/courses/{id}/{id2}/task")
    public String openCourseTest(Model model, @PathVariable("id") Integer id, @PathVariable("id2") Integer id2) {
        List<Question> questions = questionRepository.getQuestionsById(id2);
        model.addAttribute("allQuestions", questions);

        return "Teacher/Views/CourseSectionTestPage";
    }

    public void submitAnswer() {

    }

    public void checkAnswer() {

    }

    @GetMapping(value = "/courses/{id}/{id2}/calculate")
    public void calculateResults(Model model, @PathVariable("id") Integer courseId, @PathVariable("id2") Integer sectionId) {
        List<Question> questions = questionRepository.getQuestionsById(sectionId);

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

    @GetMapping("/create_course")
    public String showCreateCourse(Model model)
    {
        model.addAttribute("course", new Course());
        model.addAttribute("isVisible", true);
        return "Teacher/Views/CreateCoursePage";
    }

    @GetMapping(value = "/created_course_submitted")
    public String submitCreatedCourse(Model model, @RequestParam String name, @RequestParam String description, @RequestParam String price, @RequestParam (defaultValue="false") boolean isVisible)
    {
        java.util.Date date = new java.util.Date();
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherRepository.getTeacherByStudentId(student.getId());
        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setDate(date);
        course.setPrice(Double.parseDouble(price));
        course.setTeacher(teacher);
        course.setVoteSum(5);
        course.setVisible(isVisible);
        course.setVotersCount(1);
        courseRepository.saveAndFlush(course);
        return "redirect:/student_teacher/created_courses/";
    }

    @GetMapping("/edit_course/{id}")
    public String showEditCourse(Model model, @PathVariable("id") Integer id)
    {
        model.addAttribute("course", courseRepository.getCourseById(id));
        model.addAttribute("isVisible", true);
        model.addAttribute("teacher", teacherRepository.getTeacherById(id));
        return "Teacher/Views/EditCoursePage";
    }

    @GetMapping(value = "/edited_course_submitted/{id}")
    public String submitEditedCourse(Model model, @PathVariable("id") Integer id, @RequestParam String name, @RequestParam String description, @RequestParam String price, @RequestParam(defaultValue="true") boolean isVisible)
    {
        java.util.Date date = new java.util.Date();
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherRepository.getTeacherByStudentId(student.getId());
        Course course = courseRepository.findById(id).get();
        course.setName(name);
        course.setDescription(description);
        course.setDate(date);
        course.setPrice(Double.parseDouble(price));
        course.setTeacher(teacher);
        course.setVoteSum(5);
        course.setVisible(isVisible);
        course.setVotersCount(5);
        courseRepository.save(course);
        return "redirect:/student_teacher/created_courses/";
    }

    @GetMapping(value = "/remove_course/{id}")
    public String deleteCourse(@PathVariable("id") Integer courseId) {
        courseRepository.deleteById(courseId);
        return "redirect:/student_teacher/created_courses/";
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
