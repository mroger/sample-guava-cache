package br.org.roger.spring;

import java.util.Map;

public class MtpUtils {
    public static String replaceExpressions(final Map<String, String> expressions, String body) {
        String replacingBody = body;
        for (String expressionKey : expressions.keySet()) {
            String expression = "${" + expressionKey + "}";
            if (replacingBody.indexOf(expression) != -1) {
                replacingBody = replacingBody.replace(expression, expressions.get(expressionKey));
            }
        }
        return replacingBody;
    }
}
