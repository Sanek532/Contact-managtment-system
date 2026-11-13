//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


void main() {
    final int  MAX_USERS = 5;
    int counter = 0;
    String[] names = new String[MAX_USERS];
    String[] phones = new String[MAX_USERS];
    boolean programExit = false;
    Scanner scanner = new Scanner(System.in);

    names[0] = "Вова";
    names[1] = "Ника";
    names[2] = "Кимчи";

    phones[0] = "12345";
    phones[1] = "12344";
    phones[2] = "12567";
    counter = 3;

    do {
        System.out.println("1. Добавить контакт\t\t|\tПозволяет добавить новый контакт");
        System.out.println("2. Просмотреть контакты\t|\tОтображает список всех сохранённых контактов");
        System.out.println("3. Найти контакт\t\t|\tИщет контакт по имени и выводит его номер");
        System.out.println("4. Удалить контакт\t\t|\tУдаляет контакт по имени из системы");
        System.out.println("5. Выйти\t\t\t\t|\tЗаверает работу приложения");
        System.out.print("Выберите пункт меню и введите в консоль: ");
        String userEnter = scanner.nextLine();

        switch (userEnter) {
            case "1":
                if (counter >= MAX_USERS) {
                    System.out.println("В справочнике нет места!");
                    break;
                }

                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                if (!validateName(name)) {
                    System.out.println("Минимальная длина имени 3 символа!");
                    break;
                }

                System.out.print("Введите номер: ");
                String phone = scanner.nextLine();
                if (!validatePhone(phone)) {
                    System.out.println("Номер должен содержать только цифры и быть не короче 5 и не более 9 цифр!");
                    break;
                }

                names[counter] = name;
                phones[counter] = phone;
                counter++;
                System.out.println("Добавлен новый контакт:\nИмя:" + name + " Номер: " + phone);

                break;
            case "2":
                for (int i = 0; i < counter; i++) {
                    System.out.println((i + 1) + ". " + names[i] + " - " + phones[i]);
                }

                break;
            case "3":
                System.out.print("Введите имя: ");
                String userInput = scanner.nextLine();

                if (!validateName(userInput)) {
                    System.out.println("Минимальная длина имени 3 символа!");
                    break;
                }

                boolean nameHasFound = false;
                for (int i = 0; i < counter; i++) {
                    if (userInput.equalsIgnoreCase(names[i])) {
                        System.out.println("Телефон " + userInput + ": " + phones[i]);
                        nameHasFound = true;
                        break;
                    }
                }
                if (!nameHasFound) System.out.println("Контакт " + userInput + " не найден!");

                break;
            case "4":
                System.out.print("Введите имя: ");
                String removeInput = scanner.nextLine();

                if (!validateName(removeInput)) {
                    System.out.println("Минимальная длина имени 3 символа!");
                    break;
                }

                for (int i = 0; i < counter; i++) {
                    if (removeInput.equalsIgnoreCase(names[i])) {
                        if (counter == i + 1) {
                            names[i] = null;
                            phones[i] = null;
                            break;
                        } else {
                            for (int j = i; j < counter - 1; j++) {
                                names[j] = names[j+1];
                                phones[j] = phones[j+1];
                            }
                        }
                        counter--;
                        names[counter] = null;
                        phones[counter] = null;
                        System.out.println("Контакт " + removeInput + " удален! ");
                    }
                }

                System.out.println("Контакт " + removeInput + " не найден! ");
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

public boolean validateName(String name) {
        return (name.length() >= 3);
}

public boolean validatePhone(String phone) {
    if (phone.length() < 5 || phone.length() > 9) return false;
    for (char c : phone.toCharArray()) {
        if (!Character.isDigit(c)) return false;
    }

    return true;
}

