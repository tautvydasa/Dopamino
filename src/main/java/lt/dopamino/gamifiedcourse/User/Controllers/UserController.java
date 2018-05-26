package lt.dopamino.gamifiedcourse.User.Controllers;

import lt.dopamino.gamifiedcourse.Model.Repository.CourseRepository;
import lt.dopamino.gamifiedcourse.Model.Repository.StudentCourseRepository;
import lt.dopamino.gamifiedcourse.Model.Repository.StudentRepository;
import lt.dopamino.gamifiedcourse.Model.Student;
import lt.dopamino.gamifiedcourse.Model.Course;
import lt.dopamino.gamifiedcourse.Model.StudentCourse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public UserController(CourseRepository courseRepository, StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
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
