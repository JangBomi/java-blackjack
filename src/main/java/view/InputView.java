package view;

import model.Player;

import java.util.Scanner;

import static view.OutputView.NEW_LINE;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.nextLine();
    }

    public static String inputYesOrNo(Player player) {
        System.out.println(NEW_LINE + player.getName() +
                "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return scanner.nextLine();
    }
}