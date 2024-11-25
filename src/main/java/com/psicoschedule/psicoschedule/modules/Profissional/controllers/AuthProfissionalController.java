    package com.psicoschedule.psicoschedule.modules.Profissional.controllers;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.psicoschedule.psicoschedule.modules.Profissional.DTO.AuthProfissionalDTO;
    import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
    import com.psicoschedule.psicoschedule.modules.Profissional.useCases.AuthProfissional;

    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpSession;

    @RestController
@RequestMapping("/profissional/")
public class AuthProfissionalController {
    
    @Autowired
    private AuthProfissional authProfissional;
    
    @PostMapping("auth")
    public ResponseEntity<Object> login(@RequestBody @Validated AuthProfissionalDTO authProfissionalDTO, HttpSession session) {
        ProfissionalEntity profissional = authProfissional.autenticar(authProfissionalDTO.getLogin(), authProfissionalDTO.getSenha());
        if (profissional != null) {
            // Armazenando as informações de login na sessão
            session.setAttribute("login", profissional.getLogin());
            session.setAttribute("role", profissional.getRole());
            
            // Retornando um objeto com os dados necessários (login e role)
            return ResponseEntity.ok().body(new Object() {
                public final String login = profissional.getLogin();
                public final String role = profissional.getRole();
            });
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }

    @PostMapping("logoff")
    public String logoff(HttpServletRequest request) {
        HttpSession session = request.getSession(false); 

        if (session != null) {
            session.invalidate(); 
            return "Logoff realizado com sucesso!";
        }

        return "Nenhuma sessão ativa para finalizar.";
    }
}
