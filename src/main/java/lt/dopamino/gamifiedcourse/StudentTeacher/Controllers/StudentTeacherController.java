package lt.dopamino.gamifiedcourse.StudentTeacher.Controllers;

import lt.dopamino.gamifiedcourse.Model.*;
import lt.dopamino.gamifiedcourse.Model.Repository.*;
import lt.dopamino.gamifiedcourse.Model.Student;
import lt.dopamino.gamifiedcourse.Model.Payment;


import lt.dopamino.gamifiedcourse.Model.StudentCourse;
import lt.dopamino.gamifiedcourse.Model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    private final PaymentRepository paymentRepository;

    @Autowired
    public StudentTeacherController(StudentRepository studentRepository, PostRepository postRepository, CourseRepository courseRepository, CommentRepository commentRepository, TeacherRepository teacherRepository, StudentCourseRepository studentCourseRepository, CourseSectionRepository courseSectionRepository, QuestionRepository questionRepository, PaymentRepository paymentRepository) {

        this.studentRepository = studentRepository;
        this.postRepository = postRepository;
        this.courseRepository = courseRepository;
        this.commentRepository = commentRepository;

        this.studentCourseRepository = studentCourseRepository;
        this.courseSectionRepository = courseSectionRepository;
        this.questionRepository = questionRepository;

        this.teacherRepository = teacherRepository;

        this.paymentRepository = paymentRepository;
    }

    @GetMapping(value = "/courses/{id}/{id2}/task")
    public String openCourseTest(Model model, @PathVariable("id") Integer id, @PathVariable("id2") Integer id2) {
        List<Question> questions = questionRepository.getQuestionsById(id2);
        model.addAttribute("allQuestions", questions);

        return "Teacher/Views/CourseSectionTestPage";
    }

    @GetMapping(value = "/courses/{id}")
    public String openCourse(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("course", courseRepository.findById(id).get());
        model.addAttribute("allSections", courseSectionRepository.getCourseSectionsById(id));
        return "Teacher/Views/CoursePage";
    }

    public void submitAnswer() {

    }

    public void checkAnswer() {

    }

    @GetMapping(value = "/courses/{id}/{id2}/task/calculate")
    public void calculateResults(Model model, @PathVariable("id") Integer courseId, @PathVariable("id2") Integer sectionId, @RequestParam("answers") Integer answers) {
        List<Question> questions = questionRepository.getQuestionsById(sectionId);
        Result result = new Result();
        result.setCourse();
        result.setDate();
        result.setCourseSection();
        result.setMark();
        result.setStudent();
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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


    //---------------------------------NETRINTI-------------------------------------------------
    @GetMapping("/buypoints")
    public String openPointsShop(Model model) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherRepository.getTeacherByStudentId(student.getId());
        model.addAttribute("allCreatedCourses", courseRepository.findAllByTeacherId(teacher.getId()));
        return "Teacher/Views/PointsShopPage";
    }


    @GetMapping("/payment")
    public String openCourses(Model model, @RequestParam(value = "kiekis", required = false/*, defaultValue = "-1"*/) Integer kiekis, @Valid Student studentoTaskai) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        java.util.Date date = new java.util.Date();
        Payment mokejimas = new Payment();
        mokejimas.setStudent(student);
        mokejimas.setDate(date);
        mokejimas.setPoints(kiekis);
        mokejimas.setSum(kiekis * 0.2);
        paymentRepository.saveAndFlush(mokejimas);
        model.addAttribute("kiekis", kiekis);
        studentoTaskai.setId(student.getId());
        studentoTaskai.setEmail(student.getEmail());
        studentoTaskai.setNickname(student.getNickname());
        studentoTaskai.setPassword(student.getPassword());
        studentoTaskai.setPoints(studentRepository.getStudentPointsById(student.getId()) + kiekis);
        studentRepository.save(studentoTaskai);

        return "Teacher/Views/PaymentPage";
    }

}
