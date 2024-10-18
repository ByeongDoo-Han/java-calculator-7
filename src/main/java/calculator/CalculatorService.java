package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private final String startString = "덧셈할 문자열을 입력해 주세요.";
    private final Pattern pattern = Pattern.compile("//\\D+(0?\\D)*\\\\n");
    private final Pattern wrongPattern = Pattern.compile("^//[1-9]+.*|.*[1-9]+.*|[1-9]+\\\\n$");
    private final Pattern zeroPattern = Pattern.compile("^//0+.*|.*0+\\\\n$");
    private final Pattern nothingPattern = Pattern.compile("//\\\\n");
    private String inputString;
    private String transedString;
    private final String endString = "결과 : ";
    private BigInteger result;
    private String[] numList;
    private String[] sepList;
    public void printStartString(){
        System.out.println(startString);
    }

    public String setInputString(){
        inputString = Console.readLine();
        return inputString;
    }

    public boolean checkStartOrEndCharIsNumber(String expression){
        boolean result = true;
        int len = expression.length();
        String startChar = expression.substring(0,1);
        String endChar = expression.substring(len-1,len);
        int startInt = 0;
        if(!Character.isDigit(expression.charAt(0)) || !Character.isDigit(expression.charAt(len-1))){
            throw new IllegalArgumentException("계산식의 처음과 마지막에는 숫자만 입력할 수 있습니다.");
        }
        return result;
    }

    public String transCustomSeperator(Matcher matcher){
        String customMatcher = matcher.group();
        String customSeperator = customMatcher.substring(2, customMatcher.length()-2);
        if(customSeperator.contains("0")) {
            sepList = customSeperator.split("0");
        }else {
            sepList = new String[]{customSeperator};
        }
        String expression = inputString.substring(customMatcher.length(), inputString.length());
        transedString = expression.replaceAll(":",",");
        for(String i : sepList){
            if(!i.equals("")) {
                transedString = transedString.replaceAll(i, ",");
            }
        }
        return transedString;
    }

    public String transBasicSeperator() {
        transedString = inputString.replaceAll(":",",");
        return transedString;
    }

    public String[] getNumList(){
        return transedString.split(",");
    }

    public BigInteger calculateList() {
        BigInteger result = new BigInteger("0");
        for (String i : numList) {
            BigInteger n= new BigInteger(i);
            try{
                if(n.compareTo(new BigInteger("0"))<0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                result = result.add(n);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("등록되지 않은 구분자가 포함되어 있습니다.");
            }
        }
        return result;
    }

    public void printResult(){
        String ret = String.valueOf(result);
        StringBuffer buf = new StringBuffer(ret);
        for(int i=ret.length()-3;i>=1;i=i-3){
            buf.insert(i, ",");
        }
        System.out.println(endString+buf);
        Console.close();
    }

    public void calculate(String inputString){
        Matcher matcher = pattern.matcher(inputString);
        Matcher wrongMatcher = wrongPattern.matcher(inputString);
        Matcher nothingMatcher = nothingPattern.matcher(inputString);
        Matcher zeroMatcher = zeroPattern.matcher(inputString);
        if(matcher.find()){
            transedString = transCustomSeperator(matcher);
        }else if(nothingMatcher.find()){
            transedString = transCustomSeperator(nothingMatcher);
        }else if(zeroMatcher.find()){
            throw new IllegalArgumentException("0은 등록하고자 하는 구분자 사이에만 사용할 수 있습니다.");
        }else if(wrongMatcher.find()){
            throw new IllegalArgumentException("커스텀 구분자에 숫자를 입력할 수 없습니다.");
        }else{
            transedString = transBasicSeperator();
        }
        checkStartOrEndCharIsNumber(transedString);
        numList = getNumList();
        result = calculateList();
    }
}
