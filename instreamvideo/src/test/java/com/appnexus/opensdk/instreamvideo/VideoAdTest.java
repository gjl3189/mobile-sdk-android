/*
 *    Copyright 2013 APPNEXUS INC
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.appnexus.opensdk.instreamvideo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.instreamvideo.shadows.ShadowAsyncTaskNoExecutor;
import com.appnexus.opensdk.instreamvideo.shadows.ShadowCustomWebView;
import com.appnexus.opensdk.instreamvideo.shadows.ShadowSettings;
import com.appnexus.opensdk.instreamvideo.shadows.ShadowWebSettings;
import com.appnexus.opensdk.instreamvideo.util.Lock;
import com.appnexus.opensdk.instreamvideo.util.TestUtil;
import com.appnexus.opensdk.utils.Clog;
import com.squareup.okhttp.mockwebserver.MockResponse;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.ShadowWebView;

import static junit.framework.Assert.assertTrue;

/**
 * This tests if the API's in VideoAd are functioning as expected.
 */
@Config(constants = com.appnexus.opensdk.instreamvideo.BuildConfig.class, sdk = 21,
        shadows = {ShadowAsyncTaskNoExecutor.class, ShadowWebSettings.class, ShadowCustomWebView.class, ShadowSettings.class, ShadowLog.class})
@RunWith(RobolectricTestRunner.class)
public class VideoAdTest extends BaseRoboTest implements VideoAdLoadListener, VideoAdPlaybackListener {

    VideoAd videoAd;
    boolean adLoaded, adFailed, adPlaying;

    @Override
    public void setup() {
        super.setup();
        videoAd = new VideoAd(activity,"12345");
        videoAd.setAdLoadListener(this);
    }

    @Override
    public void tearDown(){
        super.tearDown();
        videoAd = null;
    }

    @Test
    public void testVideoDuration() throws Exception {
        int minDuration = 10;
        int maxDuration = 100;
        videoAd.setAdMinDuration(minDuration);
        videoAd.setAdMaxDuration(maxDuration);
        inspectVideoDuration(minDuration, maxDuration);
    }


    @Test
    public void testGetCreativeURL() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody(TestUTResponses.video()));

        videoAd.loadAd();
        Lock.pause(1000);
        waitForTasks();
        Robolectric.flushForegroundThreadScheduler();
        Robolectric.flushBackgroundThreadScheduler();

        waitForTasks();
        Robolectric.getBackgroundThreadScheduler().advanceToNextPostedRunnable();
        Robolectric.getForegroundThreadScheduler().advanceToNextPostedRunnable();
        assertAdLoaded(true);
        Clog.w(TestUtil.testLogTag, "VideoAdTest videoAd.getCreativeURL()" +videoAd.getCreativeURL());
        assertTrue(videoAd.getCreativeURL().equalsIgnoreCase("http://vcdn.adnxs.com/p/creative-video/05/64/6d/99/05646d99.webm"));
    }


    @Test
    public void testGetVideoAdDuration() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody(TestUTResponses.video()));

        videoAd.loadAd();
        Lock.pause(1000);
        waitForTasks();
        Robolectric.flushForegroundThreadScheduler();
        Robolectric.flushBackgroundThreadScheduler();

        waitForTasks();
        Robolectric.getBackgroundThreadScheduler().advanceToNextPostedRunnable();
        Robolectric.getForegroundThreadScheduler().advanceToNextPostedRunnable();
        assertAdLoaded(true);
        Clog.w(TestUtil.testLogTag, "VideoAdTest videoAd.getCreativeURL()" +videoAd.getCreativeURL());
        assertTrue(videoAd.getVideoAdDuration() == 96000);
    }

    @Test
    public void testGetVastXML() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody(TestUTResponses.video()));

        videoAd.loadAd();
        Lock.pause(1000);
        waitForTasks();
        Robolectric.flushForegroundThreadScheduler();
        Robolectric.flushBackgroundThreadScheduler();

        waitForTasks();
        Robolectric.getBackgroundThreadScheduler().advanceToNextPostedRunnable();
        Robolectric.getForegroundThreadScheduler().advanceToNextPostedRunnable();
        assertAdLoaded(true);
        Clog.w(TestUtil.testLogTag, "VideoAdTest videoAd.getVastXML()" +videoAd.getVastXML());
        assertTrue(videoAd.getVastXML() != "");
    }

    @Test
    public void testGetVastURL() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody(TestUTResponses.video()));

        videoAd.loadAd();
        Lock.pause(1000);
        waitForTasks();
        Robolectric.flushForegroundThreadScheduler();
        Robolectric.flushBackgroundThreadScheduler();

        waitForTasks();
        Robolectric.getBackgroundThreadScheduler().advanceToNextPostedRunnable();
        Robolectric.getForegroundThreadScheduler().advanceToNextPostedRunnable();
        assertAdLoaded(true);
        Clog.w(TestUtil.testLogTag, "VideoAdTest videoAd.getVastURL()" +videoAd.getVastURL());
        assertTrue(videoAd.getVastURL() == "");
    }

    @Test
    public void testAdPlayStarted() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody(TestUTResponses.video()));

        videoAd.loadAd();
        Lock.pause(1000);
        waitForTasks();
        Robolectric.flushForegroundThreadScheduler();
        Robolectric.flushBackgroundThreadScheduler();

        waitForTasks();
        Robolectric.getBackgroundThreadScheduler().advanceToNextPostedRunnable();
        Robolectric.getForegroundThreadScheduler().advanceToNextPostedRunnable();
        assertAdLoaded(true);

        RelativeLayout baseContainer = (RelativeLayout) activity.getWindow().getDecorView().getRootView();

        videoAd.playAd(baseContainer);

        Lock.pause(1000);
        waitForTasks();
        Robolectric.flushForegroundThreadScheduler();
        Robolectric.flushBackgroundThreadScheduler();

        waitForTasks();
        Robolectric.getBackgroundThreadScheduler().advanceToNextPostedRunnable();
        Robolectric.getForegroundThreadScheduler().advanceToNextPostedRunnable();

        assertPlayAd(true);

    }



    @Override
    public void onAdLoaded(VideoAd videoAd) {
        adLoaded = true;
        Clog.w(TestUtil.testLogTag, "VideoAdTest onAdLoaded");
    }

    @Override
    public void onAdRequestFailed(VideoAd videoAd, ResultCode errorCode) {
        adFailed = true;
        Clog.w(TestUtil.testLogTag, "VideoAdTest onAdFailed");
    }


    public void assertAdLoaded(Boolean loaded) {
        assertTrue(adLoaded || adFailed);
        assertTrue(loaded | !adFailed);
        assertTrue(loaded | adLoaded);
    }

    public void assertPlayAd(Boolean playing){
        assertTrue(adPlaying);
        assertTrue(adPlaying | playing);
    }


    private void inspectVideoDuration(int minDuration, int maxDuration){
        Assert.assertEquals(videoAd.getAdMaxDuration(), maxDuration);
        Assert.assertEquals(videoAd.getAdMinDuration(), minDuration);
    }

    @Override
    public void onAdPlaying(VideoAd videoAd) {
        adPlaying = true;
        Clog.w(TestUtil.testLogTag, "VideoAdTest onAdPlaying");
    }

    @Override
    public void onQuartile(VideoAd videoAd, Quartile quartile) {

    }

    @Override
    public void onAdCompleted(VideoAd videoAd, PlaybackCompletionState playbackCompletionStateState) {

    }

    @Override
    public void onAdMuted(VideoAd ad, boolean isMuted) {

    }

    @Override
    public void onAdClicked(VideoAd videoAd) {

    }
}
