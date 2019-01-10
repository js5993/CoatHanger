package com.example.junhosung.coathanger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.junhosung.coathanger.views.activities.LobbyActivity;
import com.example.junhosung.coathanger.views.activities.RecommendationActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;


@RunWith(AndroidJUnit4.class)
public class LobbyFragmentUITest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.junhosung.coathanger", appContext.getPackageName());
    }

    @Rule
    public IntentsTestRule<LobbyActivity> mLobbyActivityIntentsTestRule =
            new IntentsTestRule<>(LobbyActivity.class);

    @Before
    public void setup() throws Exception {
        mLobbyActivityIntentsTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void clickSeeOutfit() throws Exception {
        Espresso.onView(withId(R.id.btn_see_outfit)).perform(click());
        intended(hasComponent(RecommendationActivity.class.getName()));
    }

}
