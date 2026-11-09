
public class InfixToPostfix {

    public static int precedence(char op) {

        switch (op) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return 0;
    }

    public static String convert(String infix) {

        Stack stack = new Stack();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {

                postfix += c;
            }

            else if (c == '(') {

                stack.push(c);
            }

            else if (c == ')') {

                while (!stack.isEmpty() &&
                       stack.peek() != '(') {

                    postfix += stack.pop();
                }

                if (stack.isEmpty()) {
                    throw new IllegalArgumentException(
                        "Kurung tidak berpasangan!"
                    );
                }

                stack.pop();
            }

            else if (c == '+' || c == '-' ||
                     c == '*' || c == '/' || c == '^') {

                while (!stack.isEmpty() &&
                       stack.peek() != '(' &&
                       (precedence(stack.peek()) > precedence(c) ||
                       (precedence(stack.peek()) == precedence(c)
                       && c != '^'))) {

                    postfix += stack.pop();
                }

                stack.push(c);
            }

            else {
                throw new IllegalArgumentException(
                    "Karakter tidak valid: " + c
                );
            }
        }

        while (!stack.isEmpty()) {

            if (stack.peek() == '(') {
                throw new IllegalArgumentException(
                    "Kurung tidak berpasangan!"
                );
            }

            postfix += stack.pop();
        }

        return postfix;
    }
}
