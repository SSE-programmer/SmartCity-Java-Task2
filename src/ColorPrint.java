public class ColorPrint {

    private ColorPrint() {}

    public static void black(String text) {
        System.out.println("\033[0;30m" + text + "\033[0m");
    }

    public static void red(String text) {
        System.out.println("\033[0;31m" + text + "\033[0m");
    }

    public static void green(String text) {
        System.out.println("\033[0;32m" + text + "\033[0m");
    }

    public static void yellow(String text) {
        System.out.println("\033[0;33m" + text + "\033[0m");
    }

    public static void blue(String text) {
        System.out.println("\033[0;34m" + text + "\033[0m");
    }

    public static void purple(String text) {
        System.out.println("\033[0;35m" + text + "\033[0m");
    }

    public static void cyan(String text) {
        System.out.println("\033[0;36m" + text + "\033[0m");
    }
}
