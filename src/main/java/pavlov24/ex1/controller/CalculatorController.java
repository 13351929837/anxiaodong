package pavlov24.ex1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @PostMapping("/calc")
    public String calc(Model model,
                       @RequestParam(name="num1") Double num1,
                       @RequestParam(name="op") String op,
                       @RequestParam(name="num2") Double num2) {
        Double result = null;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    model.addAttribute("result", "Ошибка");
                    return "index";
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                model.addAttribute("result", "Ошибка");
                return "index";
        }
        model.addAttribute("result", String.format("%.2f", result));
        return "index";
    }
}