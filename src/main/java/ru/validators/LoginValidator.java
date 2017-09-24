package ru.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.List;

@FacesValidator
public class LoginValidator implements Validator {

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        try {
            String s=o.toString();
            if (s.length() < 5) {
                throw new IllegalArgumentException("Имя должно быть больше 5 символов");
            }
            if (!Character.isLetter(s.charAt(0))) {
                throw new IllegalArgumentException("Имя должно начинаться с буквы");
            }
            if (getTestArray().contains(s)) {
                throw new IllegalArgumentException("Это имя уже используется");
            }
        }catch (IllegalArgumentException e){
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    private List<String> getTestArray(){
        List<String> list=new ArrayList<String>();
        list.add("login");
        list.add("username");
        return list;
    }
}
