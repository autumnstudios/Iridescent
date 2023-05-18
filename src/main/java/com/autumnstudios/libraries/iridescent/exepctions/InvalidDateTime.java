package com.autumnstudios.libraries.iridescent.exepctions;

public class InvalidDateTime extends Exception {
    public InvalidDateTime (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
