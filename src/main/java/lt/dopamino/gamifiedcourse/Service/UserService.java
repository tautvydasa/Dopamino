package lt.dopamino.gamifiedcourse.Service;

/*
@Service
public class UserService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Autowired
    public UserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = studentRepository.findByNickname(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return user;
        }
    }
}*/