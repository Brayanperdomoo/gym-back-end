package com.sena.gym.controller;
import org.springframework.web.bind.annotation.*;
/** Endpoint para verificar que la API esta viva. */
@RestController public class HomeController { @GetMapping("/") public String home(){ return "Gym API is running"; } }
