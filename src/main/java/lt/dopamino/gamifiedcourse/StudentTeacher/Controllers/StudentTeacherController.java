/**
 * @(#) StudentTeacherController.java
 */

package lt.dopamino.gamifiedcourse.StudentTeacher.Controllers;

import lt.dopamino.gamifiedcourse.Model.Repository.CourseRepository;
import lt.dopamino.gamifiedcourse.Model.Repository.StudentRepository;
import lt.dopamino.gamifiedcourse.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student_teacher")
public class StudentTeacherController {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentTeacherController(StudentRepository studentRepository, CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
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
        model.addAttribute("allCourses", courseRepository.findAll());
        return "Teacher/Views/CoursesPage";
    }

    @GetMapping("/forum_courses")
    public String openForumCourses(Model model) {
        return "Teacher/Views/ForumCoursesPage";
    }


    public void submitRate() {

    }

    @GetMapping(value = "/courses/{id}")
    public String showPosts(Model model, @PathVariable("id") Integer id) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("student", student);
        model.addAttribute("course", courseRepository.getCourseById(id));
        return "Teacher/Views/CourseInfoPage";
    }



/*    @GetMapping("/course/{id}")
    public String openCourse(Model model, @PathVariable("id") int id) {
        Course course = courseRepository.findById(id).get();
        return "????";
    }*/

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
