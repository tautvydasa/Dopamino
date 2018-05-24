/**
 * @(#) StudentTeacherController.java
 */

package lt.dopamino.gamifiedcourse.StudentTeacher.Controllers;

import lt.dopamino.gamifiedcourse.Model.Repository.StudentRepository;
import lt.dopamino.gamifiedcourse.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student_teacher")
public class StudentTeacherController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentTeacherController(StudentRepository studentRepository) {
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
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("student", student);
        return "Teacher/Views/CreatedCoursesPage";
    }

    @GetMapping("/courses")
    public String openCourses(Model model) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("student", student);
        return "Teacher/Views/CoursesPage";
    }

    @GetMapping("/forum_courses")
    public String openForumCourses(Model model) {
        Student student = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("student", student);
        return "Teacher/Views/ForumCoursesPage";
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
