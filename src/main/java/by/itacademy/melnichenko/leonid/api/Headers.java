package by.itacademy.melnichenko.leonid.api;

import java.util.HashMap;

public class Headers {
    public HashMap<String, String> getHeaders() {
        String headersString = "Accept:application/json;version=1.1\n" +
                "Accept-Language:ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7\n" +
                "Connection:keep-alive\n" +
                "Content-Type:application/json\n" +
                "Cookie:Settings[ft_split_group]=666; Settings[userCity_]=Q3FrZQ%3D%3D.F0QCA2YACwQBGEZYR15LE1tAR1UCBQ5FfhgZF" +
                "xoKFgERC0tNEG9GBFhVWElkZlwFAhkWNBBCXUQKb0YEWFUPOzEKHQEHdABYUUEIVU8%3D; sbjs_migrations=1418474375998%3D1; s" +
                "bjs_first_add=fd%3D2023-06-21%2022%3A27%3A13%7C%7C%7Cep%3Dhttps%3A%2F%2Fwww.21vek.by%2F%3Futm_source%3Dadmi" +
                "tad%26utm_medium%3Dbanners%26utm_campaign%3Done%26utm_content%3D1370750%26tagtag_uid%3Daadbaecf8a8cc3f9e4e9" +
                "94cf29078332%7C%7C%7Crf%3Dhttps%3A%2F%2Fblogs.digitalgenics.co%2F; sbjs_first=typ%3Dutm%7C%7C%7Csrc%3Dadmit" +
                "ad%7C%7C%7Cmdm%3Dbanners%7C%7C%7Ccmp%3Done%7C%7C%7Ccnt%3D1370750%7C%7C%7Ctrm%3D%28none%29; _slid=64934f1e11" +
                "454d26ed0c1202; _gcl_au=1.1.1790378934.1687375646; mindboxDeviceUUID=da584fc4-5e8f-4d65-ab9c-d9742b6d272d; " +
                "directCrm-session=%7B%22deviceGuid%22%3A%22da584fc4-5e8f-4d65-ab9c-d9742b6d272d%22%7D; _rid=05abef431963451" +
                "583ed7d24774d5c47; _rid_anm_id=05abef431963451583ed7d24774d5c47; tmr_lvid=ef99595aacca3f9996864bae652dd49c; " +
                "tmr_lvidTS=1687375646590; _fbp=fb.1.1687375646889.1228102680; popmechanic_sbjs_migrations=popmechanic_14184" +
                "74375998%3D1%7C%7C%7C1471519752600%3D1%7C%7C%7C1471519752605%3D1; _tt_enable_cookie=1; _ttp=38hpMCDbxUAKU1Z" +
                "YYgTILFP71yP; _ym_uid=1687375647249863934; _ym_d=1687375647; clickanalyticsresource=e951ad1e-3c0a-42fc-be82" +
                "-6224edf410a7; blueID=d7754416-beb0-48aa-a9c1-92ad6318f400; tagtag_aid=32ba9fc0e8dfef7f6625e02b7022e27c; ta" +
                "gtag_aid=32ba9fc0e8dfef7f6625e02b7022e27c; tagtag_aid=32ba9fc0e8dfef7f6625e02b7022e27c; Settings[partner]=%" +
                "7B%22name%22%3A%22google%22%7D; tt_deduplication_cookie=google; tt_deduplication_cookie=google; tt_deduplic" +
                "ation_cookie=google; blueULC=google; _ga_HWRWZM3ZEW=GS1.1.1688390287.4.0.1688390307.40.0.0; ajs_user_id=%22" +
                "13990280%22; new_user=1; gnezdo_uid=XV9n6WRoqd0YT+79Up2TAg==; _ym_isad=2; _gid=GA1.2.850154499.1688753145; " +
                "Settings[detectum_filter]=Q3FrZQ%3D%3D.F0QfAjZXCw8URBQGAVIGERJDWloHRg4LIUpBVFhcBkpJUAoWRlZUWx4fNA4gGBMXBRxE" +
                "XEdeSxhAV1ZGMwQSRX5UXFlaBFcbBFBTVRBO; sbjs_current=typ%3Dutm%7C%7C%7Csrc%3Dgoogle%7C%7C%7Cmdm%3Dcpc%7C%7C%7" +
                "Ccmp%3D336837170%7C%7C%7Ccnt%3D20888055050%7C596687804571%7C%7C%7Ctrm%3D21%2520vek; _ttgclid=Cj0KCQjwkqSlBh" +
                "DaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; _ttgclid=Cj0KCQjwkqSlBhDaAR" +
                "IsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; _ttgclid=Cj0KCQjwkqSlBhDaARIsAF" +
                "JANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; Settings[u_source]=Q3FrZQ%3D%3D.BBI" +
                "fFzcABhpBXwJGAh0GEF5WHVcDC0Q%3D; sbjs_current_add=fd%3D2023-07-08%2015%3A52%3A11%7C%7C%7Cep%3Dhttps%3A%2F%2" +
                "Fwww.21vek.by%2F%3Futm_source%3Dgoogle%26utm_medium%3Dcpc%26utm_campaign%3D336837170%26utm_content%3D208880" +
                "55050%7C596687804571%26utm_term%3D21%2520vek%26gclid%3DCj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9Xt" +
                "gC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB%7C%7C%7Crf%3Dhttps%3A%2F%2Fwww.21vek.by%2F%3Futm_source%3Dgoogle%2" +
                "6utm_medium%3Dcpc%26utm_campaign%3D336837170%26utm_content%3D20888055050%7C596687804571%26utm_term%3D21%252" +
                "0vek%26gclid%3DCj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB" +
                "; sbjs_udata=vst%3D24%7C%7C%7Cuip%3D%28none%29%7C%7C%7Cuag%3DMozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Wi" +
                "n64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F114.0.0.0%20Safari%2F537." +
                "36; _gcl_aw=GCL.1688820732.Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oa" +
                "ArWQEALw_wcB; _slsession=7B9B0127-13A7-4830-8B06-D29503E67630; _ym_visorc=b; _gac_UA-32484123-1=1.168882073" +
                "6.Cj0KCQjwkqSlBhDaARIsAFJANkjunPMhhuaqeoSg1UtEaqAYG9XtgC6jLDZX16J-kj-h0S6M9J6P15oaArWQEALw_wcB; 21vek=f3127" +
                "863-e6b5-446b-9b31-8a9114a36e17; accessToken=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjAzNjc1NDMsI" +
                "mlhdCI6MTY4ODgyMDc0Mywic3ViIjoiZjMxMjc4NjMtZTZiNS00NDZiLTliMzEtOGE5MTE0YTM2ZTE3IiwiYW5vIjoxLCJ2ZXIiOjAuMX0." +
                "sDWFczQinO-YbW5d46Js33e6JMTRM7UFx7DMI4KXRco; refreshToken=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3" +
                "MjAzNjc1NDMsImlhdCI6MTY4ODgyMDc0MywiYW5vIjoxLCJqdGkiOiJmMzEyNzg2My1lNmI1LTQ0NmItOWIzMS04YTkxMTRhMzZlMTciLCJ" +
                "2ZXIiOjAuMX0.fkK0COSumL2Okgp6jvoNp6xwnh_s4hPiaqV_9Djqs9g; sbjs_session=pgs%3D2%7C%7C%7Ccpg%3Dhttps%3A%2F%2F" +
                "www.21vek.by%2F; _ga_KBL22GMK8D=GS1.1.1688820733.32.1.1688820744.49.0.0; _ga=GA1.2.1289932383.1687375647; t" +
                "mr_detect=0%7C1688820746963; _dc_gtm_UA-32484123-1=1\n" +
                "Origin:https://www.21vek.by\n" +
                "Referer:https://www.21vek.by/\n" +
                "Sec-Fetch-Dest:empty\n" +
                "Sec-Fetch-Mode:cors\n" +
                "Sec-Fetch-Site:same-origin\n" +
                "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0." +
                "0 Safari/537.36\n" +
                "cache-control:no-cache\n" +
                "pragma:no-cache\n" +
                "sec-ch-ua:\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"\n" +
                "sec-ch-ua-mobile:?0\n" +
                "sec-ch-ua-platform:\"Windows\"\n" +
                "traceparent:00-6db4250356628d6c663761b031b6733c-c3ce43493ec57740-00\n" +
                "x-requested-with:XMLHttpRequest";
        String[] pairs = headersString.split("\n");
        HashMap<String, String> headersMap = new HashMap<>();
        for (String string : pairs) {
            String[] keyValue = string.split(":");
            headersMap.put(keyValue[0], keyValue[1]);
        }
        return headersMap;
    }
}

