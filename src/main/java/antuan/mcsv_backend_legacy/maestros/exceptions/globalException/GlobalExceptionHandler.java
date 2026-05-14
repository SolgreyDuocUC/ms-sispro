package antuan.mcsv_backend_legacy.maestros.exceptions.globalException;

import antuan.mcsv_backend_legacy.maestros.exceptions.dto.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===============================
    // 404 - Recurso no encontrado
    // ===============================
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(
            NoSuchElementException ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // ===============================
    // 400 - Validaciones DTO (@Valid)
    // ===============================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        Map<String, String> validations = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validations.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Error de validación en los datos enviados",
                request.getRequestURI(),
                validations
        );

        return ResponseEntity.badRequest().body(error);
    }

    // ===============================
    // 400 - Validaciones directas
    // ===============================
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI(),
                null
        );

        return ResponseEntity.badRequest().body(error);
    }

    // ===============================
    // 409 - Conflictos de negocio
    // ===============================
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiErrorResponse> handleConflict(
            IllegalStateException ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                ex.getMessage(),
                request.getRequestURI(),
                null
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    // ===============================
    // 500 - Error general
    // ===============================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneralException(
            Exception ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse error = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Ocurrió un error inesperado en el servidor",
                request.getRequestURI(),
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
