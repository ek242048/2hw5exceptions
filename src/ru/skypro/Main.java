package ru.skypro;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        try {
            check("логин", "пароль%", "пароль");
        } catch (WrongLoginException e) {
            System.out.println("Длина логина превышает 20 символов");
            counter = counter + 1;
        }catch (WrongPasswordException e) {
            System.out.println("Пароль не прошел проверку, попробуйте ввести пароль заново");
            counter = counter + 1;
        }catch (WrongSymbolsException e) {
            System.out.println("Логин/пароль должен содержать латинские буквы в верхнем и/или " +
                    "нижнем регистре, и не должен содержать символы: +-=!@#%^&*;:~");
            counter = counter + 1;
        } finally {
            if (counter >=1 ) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }


        }



    }

    public static void check (String login, String password, String confirmPassword) {

        if ( ( login.length() > 20) ) {
            throw new WrongLoginException("Длина логина превышает 20 символов");
        }

        if (password.equals(confirmPassword)) {
        } else {
            throw new WrongPasswordException("Пароль не прошел проверку, попробуйте ввести пароль заново");
        }

        if (Pattern.matches("[a-z,A-Z]", login)) {
            throw new WrongSymbolsException("Логин/пароль должен содержать латинские буквы в верхнем и/или " +
                    "нижнем регистре, и не должен содержать символы: +-=!@#%^&*;:~");
        }

        if (Pattern.matches("[a-z,A-Z]", password)) {
            throw new WrongSymbolsException("Логин/пароль должен содержать латинские буквы в верхнем и/или " +
                    "нижнем регистре, и не должен содержать символы: +-=!@#%^&*;:~");
        }

        if (login.contains("+-=!@#%^&*;:~")) {
            throw new WrongSymbolsException("Логин/пароль должен содержать латинские буквы в верхнем и/или " +
                    "нижнем регистре, и не должен содержать символы: +-=!@#%^&*;:~");
        }

        if (password.contains("+-=!@#%^&*;:~")) {
            throw new WrongSymbolsException("Логин/пароль должен содержать латинские буквы в верхнем и/или " +
                    "нижнем регистре, и не должен содержать символы: +-=!@#%^&*;:~");
        } else {
            System.out.println("Логин: " + login + " пароль: ***********");
        }

    }




}
