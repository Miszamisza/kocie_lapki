package pl.kocie_stopki.kocie.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kocie_stopki.kocie.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String eMail) {
//        User user = userRepository.findByEMail(eMail);
//        if (user == null) throw new UsernameNotFoundException(eMail);
//
//        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return null;
    }
}