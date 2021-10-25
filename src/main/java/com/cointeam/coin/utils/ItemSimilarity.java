//package com.cointeam.coin.utils;
//
//
//import com.cointeam.coin.mapper.*;
//import com.cointeam.coin.pojo.domain.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.TreeSet;
//
//@Component
//public class ItemSimilarity {
//
//
//    @Autowired
//    Device device;
//
//    @Autowired
//    Card card;
//
//    @Autowired
//    Text text;
//
//    @Autowired
//    DeviceMapper deviceMapper;
//
//    @Autowired
//    ItemCFMapper itemCFMapper;
//
//    @Autowired
//    MyCollectCardMapper myCollectCardMapper;
//
//    @Autowired
//    MyCollectTextMapper myCollectTextMapper;
//
//    public <T> ArrayList<T> recommend(int userId) {
//
//        ArrayList<MyCollectCard> likeLists = itemCFMapper.selectAllMyCollectCard();
//
//        ArrayList<Device> devices = itemCFMapper.selectAllDevice();
//        ArrayList<Card> cards = itemCFMapper.selectAllCard();
//        ArrayList<Text> texts = itemCFMapper.selectAllText();
//
//        int[][] curMatrix = new int[cards.size() + 5][cards.size() + 5];   //当前矩阵
//        int[][] comMatrix = new int[cards.size() + 5][cards.size() + 5];   //共现矩阵
//        int[] N = new int[cards.size() + 5];                              //喜欢每个物品的人数
//
//        for (Device device : devices) {
//            if (new Integer((device.getUserId())) == userId) {
//                continue;                    //当前用户则跳过
//            }
//
//            ArrayList<MyCollectCard> myCollectCards = itemCFMapper.selectMyCollectCard(device.getUserId());//当前用户的喜欢列表
//            ArrayList<MyCollectText> myCollectTexts = itemCFMapper.selectMyCollectText(device.getUserId());
//
//            for (int i = 0; i < cards.size(); i++)
//                for (int j = 0; j < cards.size(); j++)
//                    curMatrix[i][j] = 0;                               //清空矩阵
//
//            for (int i = 0; i < likeLists.size(); i++) {
//                int pid1 = likeLists.get(i).getCardId();
//                ++N[pid1];
//                for (int j = i + 1; j < likeLists.size(); j++) {
//                    int pid2 = likeLists.get(j).getCardId();
//                    ++curMatrix[pid1][pid2];
//                    ++curMatrix[pid2][pid1]; //两两加一
//                }
//            }
//            //累加所有矩阵, 得到共现矩阵
//            for (int i = 0; i < cards.size(); i++) {
//                for (int j = 0; j < cards.size(); j++) {
//                    int pid1 = cards.get(i).getId(), pid2 = cards.get(j).getId();
//                    comMatrix[pid1][pid2] += curMatrix[pid1][pid2];
//                    comMatrix[pid1][pid2] += curMatrix[pid1][pid2];
//                }
//            }
//        }
//
//        Integer number = itemCFMapper.selectCollectNumber();
//
//        TreeSet<Card> preList = new TreeSet<Card>(new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//                if(o1.getW() != o2.getW())
//                    return (int) (o1.getW()-o2.getW())*100;
//                else
//                    return o1.getCnt() - o2.getCnt();
//            }
//        }); //预处理的列表
//
//        likeLists = itemCFMapper.selectMyCollectCard();       //当前用户喜欢的论文列表
//        boolean[] used = new boolean[cards.size()+5];  //判重数组
//        for(Like like: likeLists){
//            int Nij = 0;                         //既喜欢i又喜欢j的人数
//            double Wij;                          //相似度
//            Paper tmp;                           //当前的论文
//
//            int i = like.getPid();
//            for(Paper paper: papers){
//                if(like.getPid() == paper.getPid()) continue;
//                int j = paper.getPid();
//
//                Nij = comMatrix[i][j];
//                Wij = (double)Nij/Math.sqrt(N[i]*N[j]); //计算余弦相似度
//
//                tmp = paperdao.findPaperById(paper.getPid());
//                tmp.setW(Wij);
//
//                if(used[tmp.getPid()]) continue;
//                preList.add(tmp);
//                used[tmp.getPid()] = true;
//            }
//        }
//
//        ArrayList<Paper> recomLists = new ArrayList<>();      //生成的推荐结果
//        for(int i = 0; preList.size()>0 && i<5; i++){
//            recomLists.add(preList.pollLast());
//            preList.pollLast();
//        }
//        if(recomLists.size()<5){
//            //推荐数量不满5个, 补足喜欢数最高的文章
//            recomLists = paperdao.findTopNPapers(recomLists);
//        }
//
//        return recomLists;
//    }
//
//    }
//}