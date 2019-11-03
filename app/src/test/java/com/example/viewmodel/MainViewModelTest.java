package com.example.viewmodel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

// mengambil data dari view model
public class MainViewModelTest {
    private MainViewModel mainViewModel;

    // membuat kode berjalan sebelum pengujian dilakukan
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void init() {
        mainViewModel = new MainViewModel();
    }
    @Test
    public void calculate() throws NumberFormatException{
        String width="1";
        String length="2.4";
        String height="3";
        // membuat expectasi yang telah kita ketahui yaitu numberformatexception
        thrown.expect(NumberFormatException.class);
        // memberi message pada error yang telah di duga
        thrown.expectMessage("For input string: \"2.4\"");
        // call function from viewmodel
        mainViewModel.calculate(width, height, length);
        // mencocokkan hasil dari view model  dan expectasi
        assertEquals(6, mainViewModel.result);
    }

    @Test
    // call from expect enception
    public void emptyInputCalculateTest() throws NumberFormatException{
        String width="1";
        String length="";
        String height="3";
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("For input string: \"\"");
        mainViewModel.calculate(width, height, length);
    }


}