package com.example.demo.Upload;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class UploadExceptionHandler {

        @ExceptionHandler(MultipartException.class)
        public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
            String errorMes = e.getCause().getMessage();
            redirectAttributes.addFlashAttribute("message", errorMes);
            return "redirect:/Upload/uploadStatus";
        }

}
