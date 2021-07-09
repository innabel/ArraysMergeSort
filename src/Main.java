import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 50);
        Product[] products = new Product[n];

        // заполняем массив случайными именами и ценами, без описания
        for (int i = 0; i < products.length; i++) {
            // генерируем случайные значения для полей
            int nameInt = (int) (Math.random() * 100);
            String s = Integer.toString(nameInt);
            int price = (int) (Math.random() * 5000);

            products[i] = new Product(s, price);
        }

        // выводим массив в начальном виде до сортировки
        String format = "%1$3s %2$-8s %3$-6s %4$-12s\n";
        System.out.printf(format, ">>", "Product", "Price", "Description");
        System.out.println(Arrays.toString(products) + "\n");

        mySort(products, n);
        System.out.printf(format, ">>", "Product", "Price", "Description");
        System.out.println(Arrays.toString(products));
    }

    // merge sorting
    public static void mySort(Product[] products, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        Product[] l = new Product[mid];
        Product[] r = new Product[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = products[i];
        }
        for (int j = mid; j < n; j++) {
            r[j - mid] = products[j];
        }

        mySort(l, mid);
        mySort(r, n - mid);
        merge(products, l, r, mid, n - mid);
    }

    public static void merge(Product[] products, Product[] l, Product[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i].getPrice() <= r[j].getPrice()) {
                products[k++] = l[i++];
            } else {
                products[k++] = r[j++];
            }
        }
        while (i < left) {
            products[k++] = l[i++];
        }
        while (j < right) {
            products[k++] = r[j++];
        }
    }
}
