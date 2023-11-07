package com.rara.app.service;

import com.rara.app.dto.DailyRecordDTO;
import com.rara.app.model.mapper.DailyRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DailyRecordServiceImpl implements DailyRecordService {

    @Autowired
    DailyRecordMapper dailyRecordMapper;

    @Override
    public void insertDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception {
        dailyRecordMapper.insertDailyRecord(dailyRecordDTO);
    }

    @Override
    public void deleteDailyRecord(long id) throws Exception {
        dailyRecordMapper.deleteDailyRecord(id);
    }

    @Override
    public void updateDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception {
        dailyRecordMapper.updateDailyRecord(dailyRecordDTO);
    }

    @Override
    public void updateDailyRecordSetTitle(long id, String title) throws Exception {
        dailyRecordMapper.updateDailyRecordSetTitle(id, title);
    }

    @Override
    public void updateDailyRecordSetContent(long id, String content) throws Exception {
        dailyRecordMapper.updateDailyRecordSetContent(id, content);
    }

    @Override
    public void updateDailyRecordSetFile1(long id, String file1) throws Exception {
        dailyRecordMapper.updateDailyRecordSetFile1(id, file1);
    }

    @Override
    public void updateDailyRecordSetFile2(long id, String file2) throws Exception {
        dailyRecordMapper.updateDailyRecordSetFile2(id, file2);
    }

    @Override
    public void updateDailyRecordSetAct1Rec(long id, String act1Rec) throws Exception {
        dailyRecordMapper.updateDailyRecordSetAct1Rec(id, act1Rec);
    }

    @Override
    public void updateDailyRecordSetAct2Rec(long id, String act2Rec) throws Exception {
        dailyRecordMapper.updateDailyRecordSetAct2Rec(id, act2Rec);
    }

    @Override
    public void updateDailyRecordSetCId(long id, long cId) throws Exception {
        dailyRecordMapper.updateDailyRecordSetCId(id, cId);
    }

    @Override
    public void updateDailyRecordSetDpId(long id, long dpId) throws Exception {
        dailyRecordMapper.updateDailyRecordSetDpId(id, dpId);
    }


    @Override
    public List<DailyRecordDTO> selectDailyRecordsAll() throws Exception {
        Map<String, Object> params = new HashMap<>();
        dailyRecordMapper.selectDailyRecordsAll(params);
        return (List<DailyRecordDTO>) params.get("cursor");
    }

    @Override
    public DailyRecordDTO selectDailyRecordById(long id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        dailyRecordMapper.selectDailyRecordById(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<DailyRecordDTO> selectDailyRecordByTitle(String title) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        dailyRecordMapper.selectDailyRecordByTitle(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyRecordDTO> selectDailyRecordByContent(String content) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("content", content);
        dailyRecordMapper.selectDailyRecordByContent(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyRecordDTO> selectDailyRecordByCId(long cId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("cId", cId);
        dailyRecordMapper.selectDailyRecordByCId(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyRecordDTO> selectDailyRecordByDpId(long dpId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("dpId", dpId);
        dailyRecordMapper.selectDailyRecordByDpId(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

}
