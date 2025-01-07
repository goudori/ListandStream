package org.example;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    /**
     * ①文字列のリストをつくってください、要素数は１０個
     * 要素数に対して、文字数が2文字以上のものを抽出して、文字列に変換してカンマ区切り
     * 要素の文字列を出力する
     *
     *
     * ②数値のリストを作って、要素数は１０個
     * 要素数の数値の中から奇数の数値だけ抽出する
     * 平均値をしゅつりょくして
     *
     * ③ChatGPTにStream apiの課題を１つ作ってくれるようにいう(以下が生成AIの課題)
     * 学生の名前と成績を持つリストを作成します。
     * 成績が60点以上の学生の名前を抽出し、アルファベット順にソートしてカンマ区切りの文字列に変換して出力します。
     */

    //　①
    List<String> StudentNameList = List.of("山", "時", "田中", "たけやま", "Masayori",
        "織田", "武田", "武蔵", "T", "Alice");
    System.out.println(StudentNameList.stream().count()); //要素数を数える

    String StudentName = StudentNameList.stream()
        .filter(name -> name.length() >= 2)
        .collect(Collectors.joining(","));

    System.out.println(StudentName);

    //  ②
    List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println(numList.stream().count()); //要素数を数える

    OptionalDouble num = numList.stream()
        .filter(n -> n % 2 != 0)
        .mapToInt(Integer::intValue)
        .average();

    System.out.println(num);

    //  ③
    List<Student> students = List.of(
        new Student("Alice", 85),
        new Student("Bob", 55),
        new Student("Charlie", 70),
        new Student("David", 90),
        new Student("Eve", 45)
    );

    String studentClass = students.stream()
        .filter(student -> student.getScore() >= 60)
        .sorted(Comparator.comparing(Student::getName))
        .map(student -> student.getName())
        .collect(Collectors.joining(","));

    System.out.println(studentClass);


  }
}
