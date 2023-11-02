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
    public void deleteDailyRecord(Long id) throws Exception {
        dailyRecordMapper.deleteDailyRecord(id);
    }

    @Override
    public void updateDailyRecord(DailyRecordDTO dailyRecordDTO) throws Exception {
        dailyRecordMapper.updateDailyRecord(dailyRecordDTO);
    }

    @Override
    public void updateDailyRecordSetTitleOrContentOrFile1OrFile2(
            Map<String, Object> params) throws Exception {
        dailyRecordMapper
                .updateDailyRecordSetTitleOrContentOrFile1OrFile2(params);
    }

    @Override
    public void updateDailyRecordSetAct1RecOrAct2Rec(
            Map<String, Object> params) throws Exception {
        dailyRecordMapper
                .updateDailyRecordSetAct1RecOrAct2Rec(params);
    }

    @Override
    public void updateDailyRecordSetCIdOrDpId(
            Map<String, Object> params) throws Exception {
        dailyRecordMapper
                .updateDailyRecordSetCIdOrDpId(params);
    }


    @Override
    public List<DailyRecordDTO> selectDailyRecordsAll() throws Exception {
        Map<String, Object> params = new HashMap<>();
        dailyRecordMapper.selectDailyRecordsAll(params);
        return (List<DailyRecordDTO>) params.get("cursor");
    }

    @Override
    public DailyRecordDTO selectDailyRecordById(Long id) throws Exception {
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
    public List<DailyRecordDTO> selectDailyRecordByTitleOrContent(
            Map<String, Object> params) throws Exception {

        dailyRecordMapper.selectDailyRecordByTitleOrContent(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

    @Override
    public List<DailyRecordDTO> selectDailyRecordByCIdOrDpId(
            Map<String, Object> params) throws Exception {

        dailyRecordMapper.selectDailyRecordByCIdOrDpId(params);

        List<DailyRecordDTO> results = (List<DailyRecordDTO>) params.get("cursor");
        if (results != null && !results.isEmpty()) {
            return results;
        }
        return null;
    }

}
