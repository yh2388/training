package yc.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// FIXME
public class Calculate {
    public static void main(String[] args) {
        Map<Character, Integer> opersMap = new HashMap<>(4);
        opersMap.put('+', 0);
        opersMap.put('-', 0);
        opersMap.put('*', 1);
        opersMap.put('/', 1);
        opersMap.put('(', 99);
        opersMap.put(')', 99);
        String expr = "2+3*(4-(5+6))/7";
        System.out.println("中缀表达式：" + expr);
        //1. 转后缀表达式 3+4-5*6+1-4/2 -> 34+56*-1+42/-
        // 3+(4-5)*6+1-4/2 -> 345-6*+1+42/-
        Stack<Character> oper = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : expr.toCharArray()) {
            if (c == ')') {
                while (!oper.isEmpty() && !(oper.peek() == c)) {
                    sb.append(oper.pop());
                }
                if(!oper.isEmpty() && '('==(oper.peek())) {
                    oper.pop();
                }
                continue;
            }
            if(opersMap.get(c)!=null) {
                while (!oper.isEmpty()
                        && opersMap.get(c) <= opersMap.get(oper.peek())) {
                    if (oper.peek() == '(' ) {
                        break;
                    }
                    sb.append(oper.pop());
                }
                oper.push(c);
            } else {
                sb.append(c);
            }
        }
        while (!oper.isEmpty()) {
            sb.append(oper.pop());
        }
        System.out.println("后缀表达式：" + sb);

        //2. 计算
        // 扫描后缀表达式，数值压入数值栈，运算符压入运算符栈，
        // 当扫描到运算符时，运算符栈不为空，则跟当前运算符对比，弹出大于等于该运算符的栈内运算符，
        // 每弹出一个运算符，就弹出数值栈中前两位进行运算，先弹出的在右，后弹出的在左， 并将结果再次压入数值栈中
        Stack<Character> oper1 = new Stack<>();
        Stack<String> res = new Stack<>();

        for (char c : sb.toString().toCharArray()) {
            if(opersMap.get(c)!=null) {
                oper1.push(c);
                while (!oper1.isEmpty() && opersMap.get(c) >= opersMap.get(oper1.peek())) {
                    res.push(calculate(oper1.pop(), res.pop(), res.pop()));
                }
            } else {
                res.push(c+"");
            }
        }
        System.out.println("结果：" + res);
    }

    static String calculate(Character oper, String right, String left) {
        switch (oper) {
            case '+': return Double.parseDouble(left) + Double.parseDouble(right) +"";
            case '-': return Double.parseDouble(left) - Double.parseDouble(right) +"";
            case '*': return Double.parseDouble(left) * Double.parseDouble(right) +"";
            case '/': return Double.parseDouble(left) / Double.parseDouble(right) +"";
            default: throw new RuntimeException("Unsupport operator.");
        }
    }
}
