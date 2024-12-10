package switchcase;

public class MultiLineTextBlock {
    public static void main(String[] args) {
        String st1 = """
                    Hello World
                    Using 
                    text blocks !""";

        System.out.println("st1 = " + st1);

        // JSON TextBlock
        String phrase = """
                        { 
                        employee : "Mike", 
                        employeeId: 10001; 
                        employeeType: FT
                        }
                        """;
        System.out.println("phrase = " + phrase);

        // HTML TextBlock
        String html = """
                    <html>
                        <body>
                        <p>"Java, Programming"</p>
                        </body>
                    </html>
                    """;

        System.out.println("html = " + html);
        
        String st2 = st1.concat("This is my first text block");
        System.out.println("st2 = " + st2);


    }
}
