package universitySchoolOS.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import universitySchoolOS.model.UserPrinciple;
import universitySchoolOS.model.Users;
import universitySchoolOS.repository.UserRepo;


@Slf4j
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Users users = repo.findByEmail(username);
        log.info("users: {}", users);
        if(users == null){
            throw new UsernameNotFoundException("Username not found");
        }else {
            return new UserPrinciple(users);
        }

    }

}
