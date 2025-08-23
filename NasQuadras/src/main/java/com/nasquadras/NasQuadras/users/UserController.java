package com.nasquadras.NasQuadras.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.nasquadras.NasQuadras.security.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity createUser(@RequestBody UserModel user, HttpServletResponse response){
        UserModel usernameInstance = this.userRepository.findByUsername(user.getUsername());

        if(usernameInstance != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja cadastrado");
        }

        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);

        UserModel userInstance = this.userRepository.save(user);

        String token = JwtUtil.generateToken(userInstance.getUsername());

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);

        UserDTO responseDTO = new UserDTO(
                userInstance.getId(),
                userInstance.getUsername(),
                userInstance.getEmail(),
                userInstance.getFavoriteTeam(),
                userInstance.getFavoritePlayers()
        );

        response.addCookie(cookie);

        return ResponseEntity.ok(responseDTO);
    }





    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        UserModel userInstance = this.userRepository.findByUsername(loginRequest.getUsername());

        if (userInstance == null || !BCrypt.verifyer().verify(loginRequest.getPassword().toCharArray(), userInstance.getPassword()).verified) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos");
        }


        String token = JwtUtil.generateToken(userInstance.getUsername());

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);

        UserDTO responseDTO = new UserDTO(
                userInstance.getId(),
                userInstance.getUsername(),
                userInstance.getEmail(),
                userInstance.getFavoriteTeam(),
                userInstance.getFavoritePlayers()
        );

        response.addCookie(cookie);

        return ResponseEntity.ok(responseDTO);
    }






    @PatchMapping("/user/team")
    public ResponseEntity updateFavTeam(HttpServletRequest request, @RequestBody UpdateFavTeamRequest req){
        String username = (String) request.getAttribute("username");

        UserModel userInstance = this.userRepository.findByUsername(username);

        if(userInstance == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        userInstance.setFavoriteTeam(req.favoriteTeam());
        UserModel updatedUser = this.userRepository.save(userInstance);

        UserDTO response = new UserDTO(
                updatedUser.getId(),
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getFavoriteTeam(),
                updatedUser.getFavoritePlayers()
        );

        return ResponseEntity.ok(response);
    }






    @PatchMapping("/user/players")
    public ResponseEntity updateFavPlayers(HttpServletRequest request, @RequestBody UpdateFavPlayerRequest req){
        String username = (String) request.getAttribute("username");

        UserModel userInstance = this.userRepository.findByUsername(username);

        if(userInstance == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        userInstance.setFavoritePlayers(req.favoritePlayers());
        UserModel updatedUser = this.userRepository.save(userInstance);

        UserDTO response = new UserDTO(
                updatedUser.getId(),
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getFavoriteTeam(),
                updatedUser.getFavoritePlayers()
        );

        return ResponseEntity.ok(response);
    }
}
