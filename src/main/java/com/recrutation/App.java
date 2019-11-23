package com.recrutation;

import com.recrutation.display.View;
import com.recrutation.service.Service;

public class App {

    public static void main( String[] args ) {

        View view = new View();
        if (args != null) {
            Service service = new Service(args);
        } else {
            view.showProvideFilePathMessage();
        }
    }
}
