package com.example.Ep4GonzalesPaz.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Ep4GonzalesPaz.entity.Usuario;
import com.example.Ep4GonzalesPaz.repository.UsuarioRepository;


@AllArgsConstructor
@Controller
@RequestMapping("")
public class UserController {
    private final UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "visitas/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            model.addAttribute("username", username);
            return "redirect:/visitas";
        } else {
            model.addAttribute("error", "Nombre de usuario o contraseña inválidos");
            return "visitas/login";
        }
    }
}