package com.example.potatogaming;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.potatogaming.model.NewReleases;
import com.example.potatogaming.model.TopSellers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    List<TopSellers> topSellersList = new ArrayList<>();
    List<NewReleases> newReleasesList = new ArrayList<>();

    @Test
    public void getTopSellerListSize() {
        int res = 0;
        Assert.assertEquals(res, topSellersList.size());
    }

    @Test
    public void getNewReleaseListSize() {
        //assertEquals(4, 2 + 2);
        int res = 0;
        Assert.assertEquals(res, newReleasesList.size());
    }

    @Test
    public void getGameName() {
        TopSellers game = new TopSellers("Testing","This is a tester object","PC","Myself","Priceless", R.drawable.app_logo);
        String title = "Testing";
        Assert.assertEquals(title, game.getTitle());
    }
}