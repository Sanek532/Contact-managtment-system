//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String[] names = new String[100];
    String[] phone = new String[100];
    boolean programExit = false;
    Scanner scanner = new Scanner(System.in);


    do {
        System.out.println("1. Добавить контакт\t|\tПозволяет добавить новый контакт");
        System.out.println("2. Просмотреть контакты\t|\tОтображает список всех сохранённых контактов");
        System.out.println("3. Найти контакт\t|\tИщет контакт по имени и выводит его номер");
        System.out.println("4. Удалить контакт\t|\tУдаляет контакт по имени из системы");
        System.out.println("5. Выйти\t|\tЗавершает работу приложения");
        System.out.print("Выберите пункт меню и введите в консоль: ");
        String userEnter = scanner.nextLine();

        switch (userEnter) {
            case "1":
                System.out.println("Нажал 1");
                break;
            case "2":
                System.out.println("Нажал 2");
                break;
            case "3":
                System.out.println("Нажал 3");
                break;
            case "4":
                System.out.println("Нажал 4");
                break;
            case "5":
                System.out.println("Нажал 5 выход");
                programExit = true;
                break;
            default:
                System.out.println("Выберите пункт меню");
                break;
        }

    } while (!programExit);

}
