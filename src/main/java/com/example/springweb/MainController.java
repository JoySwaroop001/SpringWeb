package com.example.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    CredentialRepository credentialRepository;


    @Autowired
    UserdetailRepository userdetailRepository;


    @GetMapping("/")
    public String getlandingPage()
    {
        return "landingpage";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        Credential credential= new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential);
        return "signup";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model)
    {
        Optional<Credential> matchedCredential = credentialRepository.findById(username);
                if(matchedCredential.isPresent()) {
                    if (matchedCredential.get().getPassword().equals(password)) {
                        session.setAttribute("username", username);
                        Optional<Userdetail> userdetail=userdetailRepository.findById((username));
                        if(userdetail.isPresent())
                        {
                            model.addAttribute("userdetail",userdetail.get());
                        }


                        return "dashboard";
                    } else {
                        return "landingpage";
                    }
                }
                else {
                    return "landingpage";}

    }

    @PostMapping("/signup2")
    public String signup2(@RequestParam("username")String username, @RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("email") String email,@RequestParam("phone") String phone,HttpSession session)
    {
        Userdetail userdetail=new Userdetail();
        userdetail.setUsername(username);
        userdetail.setFname(fname);
        userdetail.setLname(lname);
        userdetail.setEmail(email);
        userdetail.setPhone(phone);

        session.setAttribute("username", username);

        userdetailRepository.save(userdetail);

        return "dashboard";
    }
//    @GetMapping("/save")
//    public String saveCredential(){
//        Credential cr=new Credential();
//        cr.setUsername("Jas");
//        cr.setPassword("jas@123");
//        credentialRepository.save(cr);
//        return "New Credential Saved";
//    }
}