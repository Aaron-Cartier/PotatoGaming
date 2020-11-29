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
public class UnitTest {
    List<TopSellers> topSellersList = new ArrayList<>();
    List<NewReleases> newReleasesList = new ArrayList<>();

    @Test
    public void getTopSellerListSize() {
        int res = 0;
        Assert.assertEquals(res, topSellersList.size());
    }

    @Test
    public void getNewReleaseListSize() {
        int res = 0;
        Assert.assertEquals(res, newReleasesList.size());
    }

    @Test
    public void getGameName() {
        TopSellers game = new TopSellers("Testing","This is a tester object","PC","Myself","Priceless", R.drawable.app_logo);
        String title = "Testing";
        Assert.assertEquals(title, game.getTitle());
    }

    @Test
    public void getGameDescription() {
        NewReleases game2 = new NewReleases("Testing","This is a tester object","PC","Myself","Priceless", R.drawable.app_logo);
        String description = "This is a tester object";
        Assert.assertEquals(description, game2.getDescription());
    }

    @Test
    public void getGamePrice() {
        gameRequest game3 = new gameRequest("Testing","This is a tester object","PC","Myself","Priceless", "");
        String price = "Priceless";
        Assert.assertEquals(price, game3.getGmPrice());
    }
}