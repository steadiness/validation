package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolver {

    DefaultMessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        /*for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }*/
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        /*for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }*/
        //bindingResult.addError(new FieldError("item", "itemName", null, false, messageCodes, null, null)
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
