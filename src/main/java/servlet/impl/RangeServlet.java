package servlet.impl;

import servlet.DateCenterServlet;

public class RangeServlet  {

//    public void run() throws IOException {
//        Map<String,Object> map=new HashMap<String, Object>();
//        map.put("filterBy","Category");
//        //  Map<String,Object> map2=new HashMap<String,Object>();
//        // map2.put("filterBy",map);
//        String str="https://api.se.com/rest/pim/productoffer/1.0/filters/search?loc=zh_CN&tBrand=Schneider%20Electric&tCountry=CN";
//        String str2 = HttpClient.doPost(str,map,"{\"getFilter\": {\"filterBy\": \"Category\"}}");
//        //test();
//        System.out.println(str2);
//        InputStream is = Resources.getResourceAsStream("mybatis");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        SqlSession session=factory.openSession();
//        Summary summary=(Summary) session.selectOne("SummaryMapper.selectSummary","001");
//        System.out.println(summary.getDate());
//        session.close();
//        RequestServiceImpl requestServiceimpl=new RequestServiceImpl();
//         String str=requestServiceimpl.doGet( Conf.GetConf().getUrl());
//
//
//    }
//    public void getConf() {
//        rConf.getConf().getCategoryId();
//    }
//
//    /**
//     * 获取数据
//     */
//    public void getData() {
//
//    }


//    /**
//     * json转为对象
//     */
//
//    public void test() {
//        String str = "{\n" +
//                "    \"getRangesOfCatResponse\": {\n" +
//                "        \"return\": {\n" +
//                "            \"categoryName\": \"开关和插座-防水防溅盒和特殊应用\",\n" +
//                "            \"categoryOriginalName\": \"Light Switches and Sockets: Weatherproof and Dedicated Application\",\n" +
//                "            \"id\": \"5630\",\n" +
//                "            \"pictureDescription\": \"开关和插座-防水防溅盒和特殊应用\",\n" +
//                "            \"pictureId\": \"207279\",\n" +
//                "            \"ranges\": [\n" +
//                "                {\n" +
//                "                    \"id\": \"8158712\",\n" +
//                "                    \"pictureDescription\": \"Merten Aquadesign\",\n" +
//                "                    \"pictureId\": \"204460\",\n" +
//                "                    \"rangeId\": \"1530\",\n" +
//                "                    \"rangeName\": \"Merten Aquadesign\",\n" +
//                "                    \"rangeOriginalName\": \"Merten Aquadesign\",\n" +
//                "                    \"shortDescription\": \"Merten Aquadesign\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"id\": \"8335678\",\n" +
//                "                    \"pictureDescription\": \"地插系列\",\n" +
//                "                    \"pictureId\": \"304547\",\n" +
//                "                    \"rangeId\": \"2056\",\n" +
//                "                    \"rangeName\": \"地插系列\",\n" +
//                "                    \"rangeOriginalName\": \"Wallbox / Module / Coupling / Junction Box\",\n" +
//                "                    \"shortDescription\": \"铜筋铁骨 宛如磐石\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"id\": \"8335690\",\n" +
//                "                    \"pictureDescription\": \"莫顿-灵幻系列/边框\",\n" +
//                "                    \"pictureId\": \"235410\",\n" +
//                "                    \"rangeId\": \"2072\",\n" +
//                "                    \"rangeName\": \"莫顿-灵幻系列/边框\",\n" +
//                "                    \"rangeOriginalName\": \"[Range Oid:8335690]\",\n" +
//                "                    \"shortDescription\": \"外观设计优质的开关插座\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"id\": \"8335716\",\n" +
//                "                    \"pictureDescription\": \"地插\",\n" +
//                "                    \"pictureId\": \"235412\",\n" +
//                "                    \"rangeId\": \"2105\",\n" +
//                "                    \"rangeName\": \"地插\",\n" +
//                "                    \"rangeOriginalName\": \"[Range Oid:8335716]\",\n" +
//                "                    \"shortDescription\": \"铜筋铁骨 宛如磐石\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"id\": \"8335757\",\n" +
//                "                    \"pictureDescription\": \"莫顿面板开关\",\n" +
//                "                    \"pictureId\": \"235414\",\n" +
//                "                    \"rangeId\": \"2147\",\n" +
//                "                    \"rangeName\": \"莫顿面板开关\",\n" +
//                "                    \"rangeOriginalName\": \"[Range Oid:8335757]\",\n" +
//                "                    \"shortDescription\": \"尖端品质，源自德国\"\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"id\": \"19071646\",\n" +
//                "                    \"pictureDescription\": \"kavacha天甲系列\",\n" +
//                "                    \"pictureId\": \"175822\",\n" +
//                "                    \"rangeId\": \"61235\",\n" +
//                "                    \"rangeName\": \"kavacha天甲系列\",\n" +
//                "                    \"rangeOriginalName\": \"Kavacha\",\n" +
//                "                    \"shortDescription\": \"提供最佳全时防水保护\"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//        //(1)解析json数据，并把数据放到map里面
//
//      JSONObject object = JSON.parseObject(str);
//        JSONObject respObj = object.getJSONObject("getRangesOfCatResponse");
//        for (int i = 0; i < respObj.getJSONObject("return").getJSONArray("ranges").size(); i++) {
//            System.out.println(JSON.parseObject(respObj.getJSONObject("return").getJSONArray("ranges").get(i).toString()).getLongValue("pictureId"));
//        }


//    /**
//     * 判断MD5是否重复
//     */
    //  public boolean isRepetition(String id,String data){
//        String md5=MD5.getMD5(String data);
//        Summary summary=new Summary();
//        summary.getSummary(id);
    //     return true;//md5.equals("");

    // }
//
//    /**
//     *存储数据，并统计
//     */
//
//    /**
//     * 发送邮件
//     * @param content
//     */
//    public void sendMail(String content){
//        Mail mail=new Mail();
//        mail.sendMail(content);
//    }
}