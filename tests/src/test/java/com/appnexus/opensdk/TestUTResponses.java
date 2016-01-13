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

package com.appnexus.opensdk;

import android.net.Uri;

import com.appnexus.opensdk.util.TestUtil;
import com.appnexus.opensdk.vastdata.AdModel;
import com.appnexus.opensdk.vastdata.ClickTrackingModel;
import com.appnexus.opensdk.vastdata.CreativeModel;
import com.appnexus.opensdk.vastdata.LinearAdModel;
import com.appnexus.opensdk.vastdata.MediaFileModel;
import com.appnexus.opensdk.vastdata.TrackingModel;
import com.appnexus.opensdk.vastdata.VideoClickModel;

import java.util.ArrayList;

/**
 * Used for mock responses
 */
public class TestUTResponses {

    public static final String RESULTCB = "http://result.com/";

    // template strings
    private static final String CLASSNAME = "com.appnexus.opensdk.testviews.%s";

    // impbus response

    // /ut mock response
    private static final String UT_RESPONSE = "{\"version\":\"0.0.2\",\"tags\":[{\"uuid\":\"null\",\"auction_id\":\"5049928823070184480\",\"ut_url\":\"\",\"tag_id\":5778861,\"ads\":[{\"content_source\":\"rtb\",\"ad_type\":\"%s\",\"buyer_member_id\":3535,\"creative_id\":37357778,\"media_type_id\":4,\"media_subtype_id\":64,\"notify_url\":\"\",\"rtb\":{\"video\":{\"player_width\":0,\"duration_ms\":142000,\"playback_methods\":[\"auto_play_sound_off\"],\"frameworks\":[],\"content\":\"%s\"}}}]}]}";
    private static final String UT_AD_TYPE_BANNER = "banner";
    private static final String UT_AD_TYPE_VIDEO = "video";
    private static final String UT_HTML_RESPONSE = "{\"version\":\"0.0.2\",\"tags\":[{\"uuid\":\"null\",\"auction_id\":\"5049928823070184480\",\"ut_url\":\"\",\"tag_id\":5778861,\"ads\":[{\"content_source\":\"rtb\",\"ad_type\":\"banner\",\"buyer_member_id\":229,\"creative_id\":10124375,\"media_type_id\":1,\"media_subtype_id\":1,\"notify_url\":\"\",\"rtb\":{\"banner\":{\"width\":320,\"height\":480,\"content\":\"%s\"}}}]}]}";
    private static final String VAST_XML_RESPONSE = "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" standalone=\\\"yes\\\"?><VAST version=\\\"2.0\\\"><Ad id=\\\"37357778\\\"><Wrapper><AdSystem version=\\\"2.0\\\">adnxs</AdSystem><VASTAdTagURI><![CDATA[/]]></VASTAdTagURI><Error><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=4&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Error><Impression id=\\\"adnxs\\\"><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=9&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Impression><Creatives><Creative id=\\\"9408\\\"><Linear><TrackingEvents><Tracking event=\\\"start\\\"><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=2&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Tracking><Tracking event=\\\"firstQuartile\\\"><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=5&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Tracking><Tracking event=\\\"midpoint\\\"><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=6&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Tracking><Tracking event=\\\"thirdQuartile\\\"><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=7&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Tracking><Tracking event=\\\"complete\\\"><![CDATA[http://nym1.ib.adnxs.com/vast_track?e=wqT_3QKcBPBCEwIAAAIA1gAFCNmV6rEFEKCo68Ck8LyKRhjwpr3Ju4qAuhEgASotCXsUrkfheoQ_EXsUrkfheoQ_GQAAAAAAAPA_IRESACkRCagwrdvgAjjPG0DPG0gCUNKR6BFY2oYzYABo5MMBeLTQAoABAYoBA1VTRJIBAQbwUpgBwAKgAeADqAEBsAEAuAEAwAEDyAEA0AEA2AEA4AEA8AEAigI6dWYoJ2EnLCA2NTI4ODcsIDE0NDY2NzcyMDkpO3VmKCdyJywgMzczNTc3NzgsMh4A8LSSAqUBIU5pZk8td2piMDU0RkVOS1I2QkVZQUNEYWhqTXdBRGdBUUFSSXp4dFFyZHZnQWxnQVlGaG9BSEFBZUFDQUFRQ0lBUUNRQVFHWUFRR2dBUUdvQVFPd0FRQzVBWHNVcmtmaGVvUV93UUY3Rks1SDRYcUVQOGtCX1p2clU1SmdfVF9aQVFBQUFBQUFBUEFfNEFFQTlRRUFBQUFBbUFLS2lNeUVEZy4umgIdIWxRYXNQZ2piLqgA8Hcyb1l6SUFRLtgCAOACpKsrgAMAiAMBkAMAmAMXoAMBqgMAsAMAuAMAwAOQHMgDANIDKAgAEiRhNjVjMTExYy1kMjI4LTQ2OTctODAxZC0wYTMyODI1OGEwYzbYAwDgAwDoAwDwAwD4AwCABACSBAYvdXQvdjGYBAA.&event=8&s=09b6f53d34cc1ac313608a19d6920de34f1140f8]]></Tracking></TrackingEvents><VideoClicks><ClickTracking id=\\\"adnxs\\\"><![CDATA[http://nym1.ib.adnxs.com/click?exSuR-F6hD97FK5H4XqEPwAAAAAAAPA_exSuR-F6hD97FK5H4XqEPyDUGkiC8xRGcFMvuVMAdBHZijpWAAAAAK0tWADPDQAAzw0AAAIAAADSCDoCWsMMAAAAAQBVU0QAVVNEAEAB4AHkYQAANKgBAAMAAQAAAKYARSJsoQAAAAA./cnd=%21lQasPgjb054FENKR6BEY2oYzIAQ./]]></ClickTracking></VideoClicks></Linear></Creative></Creatives></Wrapper></Ad></VAST>";
    private static final String VAST_INLINE_RESPONSE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><VAST xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n" +
            "\t  xsi:noNamespaceSchemaLocation=\"vast2.xsd\" version=\"2.0\"><Ad id=\"Customized\"><InLine><AdSystem>Open AdStream</AdSystem><AdTitle>Customized</AdTitle><Description>ad Description</Description><Impression><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ieg/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?]]></Impression><Creatives><Creative><Linear><Duration>00:01:01</Duration><TrackingEvents><Tracking event=\"start\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=start&XE]]></Tracking><Tracking event=\"midpoint\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=midpoint&XE]]></Tracking><Tracking event=\"firstQuartile\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=firstQuartile&XE]]></Tracking><Tracking event=\"thirdQuartile\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=thirdQuartile&XE]]></Tracking><Tracking event=\"complete\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=complete&XE]]></Tracking><Tracking event=\"mute\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=mute&XE]]></Tracking><Tracking event=\"pause\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=pause&XE]]></Tracking><Tracking event=\"fullscreen\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=fullscreen&XE]]></Tracking><Tracking event=\"rewind\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=rewind&XE]]></Tracking><Tracking event=\"unmute\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=unmute&XE]]></Tracking><Tracking event=\"expand\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=expand&XE]]></Tracking><Tracking event=\"collapse\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=collapse&XE]]></Tracking><Tracking event=\"acceptInvitation\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=acceptInvitation&XE]]></Tracking><Tracking event=\"close\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=close&XE]]></Tracking><Tracking event=\"resume\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=resume&XE]]></Tracking><Tracking event=\"creativeView\"><![CDATA[http://oasc18.247realmedia.com/t/video-demo.appnexus.com/outstream_1/L35/1298238887@x01/ld/L35/TJM_Imp/demo_outstream_1/creative_3_vast_x01/574e6d6d2b46574d4d3077414270354f?XE&oas_iactId=creativeView&XE]]></Tracking></TrackingEvents><VideoClicks><ClickThrough><![CDATA[http://oasc18.247realmedia.com/5c/video-demo.appnexus.com/outstream_1/L35/1298238887/x01/TJM_Imp/demo_outstream_1/creative_3_vast_x01.xml/574e6d6d2b46574d4d3077414270354f?]]></ClickThrough></VideoClicks><MediaFiles><MediaFile delivery=\"progressive\" bitrate=\"1049\" width=\"854\" height=\"480\" type=\"video/mp4\"><![CDATA[http://imagec18.247realmedia.com/0/TJM_Imp/demo_outstream_1/524D5F5641535431_creative_3_vast_x01.mp4/1446478842]]></MediaFile></MediaFiles></Linear></Creative></Creatives></InLine></Ad></VAST>";
    private static final String BANNER = "temp content"; // TODO add mock content here

    // /mob mock response
    private static final String RESPONSE = "{\"status\":\"%s\",\"ads\":%s,\"mediated\":%s,\"native\":%s,\"version\":%d}";
    private static final String ADS = "[{ \"type\": \"%s\", \"width\": %d, \"height\": %d, \"content\": \"%s\" }]";
    private static final String MEDIATED_AD = "{\"type\":\"%s\",\"class\":\"%s\",\"param\":\"%s\",\"width\":\"%d\",\"height\":\"%d\",\"id\":\"%s\"}";
    private static final String MEDIATED_ARRAY_SINGLE_AD = "[{ \"handler\": [{\"type\":\"%s\",\"class\":\"%s\",\"param\":\"%s\",\"width\":\"%d\",\"height\":\"%d\",\"id\":\"%s\"}],\"result_cb\":\"%s\"}]";
    private static final String HANDLER = "{ \"handler\": [%s],\"result_cb\":\"%s\"}";
    private static final String HANDLER_NO_RESULTCB = "{ \"handler\": [%s]}";
    private static final String MEDIATED_ARRAY = "[%s]";

    private static final String MRAID_CONTENT = "<script type=\\\"text/javascript\\\" src=\\\"mraid.js\\\"></script><script type=\\\"text/javascript\\\">document.write('<div style=\\\"background-color:#EF8200;height:1000px;width:1000px;\\\"><p>%s</p></div>');</script>";

    private static final String AN_NATIVE_RESPONSE = "[{\"type\":\"%s\",\"title\":\"%s\",\"description\":\"%s\",\"full_text\":\"%s\",\"context\":\"%s\",\"icon_img_url\":\"%s\",\"main_media\":%s,\"cta\":\"%s\",\"click_trackers\":[%s],\"impression_trackers\":[%s],\"rating\":%s,\"click_url\":\"%s\",\"click_fallback_url\":\"%s\",\"custom\":%s}]";
    private static final String NATIVE_MAIN_MEDIA = "[{\"url\":\"%s\",\"width\":%d,\"height\":%d,\"label\":\"default\"},{\"url\":\"%s\",\"width\":%d,\"height\":%d},{\"url\":\"%s\",\"width\":%d,\"height\":%d}]";
    private static final String NATIVE_RATING = "{\"value\":%.2f,\"scale\":%.2f}";
    private static final String EMPTY_ARRAY = "[]";
    private static final String STATUS_OK = "ok";
    private static final String STATUS_NO_BID = "no_bid";

    public static String blank() {
        return "";
    }

    public static String utHTMLBanner() {
        return templateAdsResponse("banner", 320, 480, "content");
    }

    public static String videoUT() {
        return templateUTResponse(UT_AD_TYPE_VIDEO, VAST_XML_RESPONSE);
    }

    public static String bannerUT() {
        return templateUTResponse(UT_AD_TYPE_BANNER, BANNER);
    }

    public static String getVastInlineResponse() {
        return VAST_INLINE_RESPONSE;
    }

    public static String getUTHTMLResponse() {
        return UT_HTML_RESPONSE;
    }

    public static String templateUTResponse(String adType, String content) {
        return String.format(UT_RESPONSE, adType, content);
    }

    // templates

    public static String templateResponse(String status, String ads, String mediated, String nativeResponse, int version) {
        return String.format(RESPONSE, status, ads, mediated, nativeResponse, version);
    }

    public static String templateAdsResponse(String type, int width, int height, String content) {
        String ads = String.format(ADS, type, width, height, content);
        return templateResponse(STATUS_OK, ads, EMPTY_ARRAY, EMPTY_ARRAY, TestUtil.VERSION);
    }


    // Following are wei's Code
    public static AdModel getVastAdModel() {
        AdModel adModel = new AdModel();
        // add a linear ad to the creatives list
        ArrayList<CreativeModel> creatives = new ArrayList<CreativeModel>();
        CreativeModel creativeModel = new CreativeModel();
        LinearAdModel linearAdModel = new LinearAdModel();
        linearAdModel.setSkipOffset("00:00:05"); // 5 seconds absolute skipOffset
        linearAdModel.setDuration("00:00:30");
        ArrayList<TrackingModel> trackingList = new ArrayList<TrackingModel>();
        TrackingModel creativeView = new TrackingModel();
        creativeView.setEvent(CREATIVE_VIEW);
        creativeView.setURL(CREATIVE_VIEW_URL);
        trackingList.add(creativeView);
        TrackingModel start = new TrackingModel();
        start.setEvent(START);
        start.setURL(START_URL);
        trackingList.add(start);
        TrackingModel first = new TrackingModel();
        first.setEvent(FIRST_QUARTILE);
        first.setURL(FIRST_QUARTILE_URL);
        trackingList.add(first);
        TrackingModel mid = new TrackingModel();
        mid.setEvent(MID_POINT);
        mid.setURL(MID_POINT_URL);
        trackingList.add(mid);
        TrackingModel third = new TrackingModel();
        third.setEvent(THIRD_QUARTILE);
        third.setURL(THIRD_QUARTILE_URL);
        trackingList.add(third);
        TrackingModel complete = new TrackingModel();
        complete.setEvent(COMPLETE);
        complete.setURL(COMPLETE_URL);
        trackingList.add(complete);
        TrackingModel mute = new TrackingModel();
        mute.setEvent(MUTE);
        mute.setURL(MUTE_URL);
        trackingList.add(mute);
        TrackingModel unmute = new TrackingModel();
        unmute.setEvent(UNMUTE);
        unmute.setURL(UNMUTE_URL);
        trackingList.add(unmute);
        TrackingModel pause = new TrackingModel();
        pause.setEvent(PAUSE);
        pause.setURL(PAUSE_URL);
        trackingList.add(pause);
        TrackingModel resume = new TrackingModel();
        resume.setEvent(RESUME);
        resume.setURL(RESUME_URL);
        trackingList.add(resume);
        TrackingModel full = new TrackingModel();
        full.setEvent(FULL_SCREEN);
        full.setURL(FULL_SCREEN_URL);
        trackingList.add(full);
        TrackingModel rewind = new TrackingModel();
        rewind.setEvent(REWIND);
        rewind.setURL(REWIND_URL);
        trackingList.add(rewind);
        TrackingModel exit = new TrackingModel();
        exit.setEvent(EXIT_FULL_SCRREEN);
        exit.setURL(EXIT_FULL_SCRREEN_URL);
        trackingList.add(exit);
        TrackingModel expand = new TrackingModel();
        expand.setEvent(EXPAND);
        expand.setURL(EXPAND_URL);
        trackingList.add(expand);
        TrackingModel collapse = new TrackingModel();
        collapse.setEvent(COLLAPSE);
        collapse.setURL(COLLAPSE_URL);
        trackingList.add(collapse);
        TrackingModel accept = new TrackingModel();
        accept.setEvent(ACCEPT_INVITATION);
        accept.setURL(ACCEPT_INVITATION_URL);
        trackingList.add(accept);
        TrackingModel close = new TrackingModel();
        close.setEvent(CLOSE_LINEAR);
        close.setURL(CLOSE_LINEAR_URL);
        trackingList.add(close);
        TrackingModel skip = new TrackingModel();
        skip.setEvent(SKIP);
        skip.setURL(SKIP_URL);
        trackingList.add(skip);
        TrackingModel progress = new TrackingModel();
        progress.setEvent(PROGRESS);
        progress.setURL(PROGRESS_URL);
        trackingList.add(progress);
        linearAdModel.setTrackingEventArrayList(trackingList);
        ArrayList<MediaFileModel> mediaFileList = new ArrayList<MediaFileModel>();
        MediaFileModel mediaFileModel = new MediaFileModel();
        Uri videoUri = Uri.parse("android.resource://" + TestUTResponses.class.getPackage().getName() + "/" + R.raw.test_video);
        mediaFileModel.setUrl(videoUri.toString());
        mediaFileModel.setBitrate("500");
        mediaFileModel.setWidth("720");
        mediaFileModel.setHeight("480");
        mediaFileModel.setScalable("true");
        mediaFileModel.setMaintainAspectRatio("true");
        mediaFileModel.setDelivery("progressive");
        mediaFileModel.setType("video/mp4");
        mediaFileList.add(mediaFileModel);
        linearAdModel.setMediaFilesArrayList(mediaFileList);
        ArrayList<VideoClickModel> videoClicks = new ArrayList<VideoClickModel>();
        VideoClickModel videoClickModel = new VideoClickModel();
        videoClickModel.setClickThroughURL(CLICK_THROUGH_URL);
        ArrayList<ClickTrackingModel> clickTrackingList = new ArrayList<ClickTrackingModel>();
        ClickTrackingModel clickTrackingModel1 = new ClickTrackingModel();
        clickTrackingModel1.setURL(CLICK_TRACKING_URL1);
        ClickTrackingModel clickTrackingModel2 = new ClickTrackingModel();
        clickTrackingModel2.setURL(CLICK_TRACKING_URL2);
        clickTrackingList.add(clickTrackingModel1);
        clickTrackingList.add(clickTrackingModel2);
        videoClickModel.setClickTrackingArrayList(clickTrackingList);
        videoClicks.add(videoClickModel);
        linearAdModel.setVideoClicksArrayList(videoClicks);
        creativeModel.setLinearAdModel(linearAdModel);
        creatives.add(creativeModel);
        adModel.setCreativesArrayList(creatives);
        // set impression url
        ArrayList<String> impressions = new ArrayList<String>();
        impressions.add(IMPRESSION_URL_1);
        impressions.add(IMPRESSION_URL_2);
        adModel.setImpressionArrayList(impressions);
        // Followings are optionals
        // add adSystemn
        adModel.setAdSystem("AppNexus");
        // add AdTitle
        adModel.setAdTitle("Test Video");
        // add Description
        adModel.setDescription("VAST 3.0");
        // add Advertiser
        adModel.setAdvertiser("AppNexus");
        // add Pricing
        adModel.setPricing("1.0"); // TODO this should not be a string
        // add Survey
        adModel.setSurvey(SURVEY_URL);
        // set Error
        adModel.setError(ERROR_URL);
        return adModel;
    }

    static String IMPRESSION_URL_1 = "http://impression1.com";
    static String IMPRESSION_URL_2 = "http://impression2.com";
    static String CLICK_TRACKING_URL1 = "http://click1.com";
    static String CLICK_TRACKING_URL2 = "http://click2.com";
    static String CLICK_THROUGH_URL = "http://www.appnexus.com";
    static String SURVEY_URL = "http://survey.com";
    static String ERROR_URL = "http://error.com";
    // Tracking Events urls
    static String CREATIVE_VIEW = "creativeView";
    static String CREATIVE_VIEW_URL = "http://creativeview.com";
    static String START = "start";
    static String START_URL = "http://start.com";
    static String FIRST_QUARTILE = "firstQuartile";
    static String FIRST_QUARTILE_URL = "http://first.com";
    static String MID_POINT = "midpoint";
    static String MID_POINT_URL = "http://midpoint.com";
    static String THIRD_QUARTILE = "thirdQuartile";
    static String THIRD_QUARTILE_URL = "http://third.com";
    static String COMPLETE = "complete";
    static String COMPLETE_URL = "http://complete.com";
    static String MUTE = "mute";
    static String MUTE_URL = "http://mute.com";
    static String UNMUTE = "unmute";
    static String UNMUTE_URL = "http://unmute.com";
    static String PAUSE = "pause";
    static String PAUSE_URL = "http://pause.com";
    static String RESUME = "resume";
    static String RESUME_URL = "http://resume.com";
    static String FULL_SCREEN = "fullscreen";
    static String FULL_SCREEN_URL = "http://fullscreen.com";
    static String REWIND = "rewind";
    static String REWIND_URL = "http://rewind.com";
    static String EXIT_FULL_SCRREEN = "exitFullscreen";
    static String EXIT_FULL_SCRREEN_URL = "http://exitfullscreen.com";
    static String EXPAND = "expand";
    static String EXPAND_URL = "http://expand.com";
    static String COLLAPSE = "collapse";
    static String COLLAPSE_URL = "http://collapse.com";
    static String ACCEPT_INVITATION = "acceptInvitationLinear";
    static String ACCEPT_INVITATION_URL = "http://acceptinvitation.com";
    static String CLOSE_LINEAR = "closeLinear";
    static String CLOSE_LINEAR_URL = "http://closelinear.com";
    static String SKIP = "skip";
    static String SKIP_URL = "http://skip.com";
    static String PROGRESS = "progress";
    static String PROGRESS_URL = "http://progress.com";
}
