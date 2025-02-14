package com.example.subscription_alertas.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.subscription_alertas.model.VitalSigns;
import com.example.subscription_alertas.repository.VitalSignsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

    @Autowired
    private VitalSignsRepository vitalSignsRepository;


    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "alertas", groupId = "subscripcion-grupo")
    public void listen(String message) {
        System.out.println("Mensaje recibido desde Kafka: " + message);
        
        // Aquí puedes llamar al servicio para guardar en Oracle
        guardarEnBaseDeDatos(message);
    }

     private void guardarEnBaseDeDatos(String mensaje) {
        try {
            // Convertir el mensaje JSON a un objeto Java
            VitalSigns vitalSigns = objectMapper.readValue(mensaje, VitalSigns.class);
            
             // Asignar la fecha actual si no está presente
            if (vitalSigns.getFecha() == null) {
                vitalSigns.setFecha(new Date()); // 🔹 Asigna la fecha actual
            }
            // Guardar en la base de datos
            vitalSignsRepository.save(vitalSigns);
            System.out.println("Datos guardados en Oracle: " + vitalSigns);
            
        } catch (Exception e) {
            System.err.println("Error al procesar el mensaje: " + e.getMessage());
        }
    }
}