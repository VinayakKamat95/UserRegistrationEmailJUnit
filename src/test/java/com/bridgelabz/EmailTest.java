package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class EmailTest {
    //*initializing fields email and expected(result boolean)*//
    String email;
    boolean expected;

    //*Constructor created to provide current object value*//
    public EmailTest(String email, boolean result) {
        this.email = email;
        this.expected = result;
    }

    /*Parameters for class in list format is provided in the inputEmail method*/
    @Parameterized.Parameters
    public static List inputEmail(){
        List list = new ArrayList();

        list.add(new Object[]{"abc@yahoo.com,",true});
        list.add(new Object[]{"abc-100@yahoo.com,",true});
        list.add(new Object[]{"abc.100@yahoo.com",true});
        list.add(new Object[]{"abc111@abc.com,",true});
        list.add(new Object[]{"abc-100@abc.net,",true});
        list.add(new Object[]{"abc.100@abc.com.au",true});
        list.add(new Object[]{"abc@1.com,",true});
        list.add(new Object[]{"abc@gmail.com.com",true});
        list.add(new Object[]{"abc+100@gmail.com",true});
        list.add(new Object[]{"abc",false});
        list.add(new Object[]{"abc@.com.my",false});
        list.add(new Object[]{"abc123@gmail.a",false});
        list.add(new Object[]{"abc123@.com",false});
        list.add(new Object[]{"abc123@.com.com",false});
        list.add(new Object[]{".abc@abc.com",false});
        list.add(new Object[]{"abc()*@gmail.com",false});
        list.add(new Object[]{"abc@%*.com",false});
        list.add(new Object[]{"abc..2002@gmail.com",false});
        list.add(new Object[]{"abc@abc@gmail.com",false});
        list.add(new Object[]{"abc@gmail.com.1a",false});
        list.add(new Object[]{"abc@gmail.com.aa.au",false});
        return list;
    }

    //*Object of validatorEmail class created
    // checking validateEmail methods result with expected result using equals method*//
    @Test
    public void validateEmail() {
        UserEmailValidator userValidator = new UserEmailValidator();
        Assert.assertEquals(this.expected,
                userValidator.validateEmail(this.email));
    }
}
