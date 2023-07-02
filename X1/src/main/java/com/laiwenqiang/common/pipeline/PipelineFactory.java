package com.laiwenqiang.common.pipeline;

/**
 * @author Lion
 * @date 2023/6/22 11:16
 */
public interface PipelineFactory {
    /**
     * 根据业务编号获取对应的Pipeline
     *
     * @param bizCode 业务编号
     * @return Pipeline
     */
    Pipeline getPipeline(String bizCode);
}
