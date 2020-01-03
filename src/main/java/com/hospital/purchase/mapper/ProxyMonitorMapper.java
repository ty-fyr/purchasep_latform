package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.ProxyMonitor;

public interface ProxyMonitorMapper {
    int deleteByPrimaryKey(Integer proxyId);

    int insert(ProxyMonitor record);

    int insertSelective(ProxyMonitor record);

    ProxyMonitor selectByPrimaryKey(Integer proxyId);

    int updateByPrimaryKeySelective(ProxyMonitor record);

    int updateByPrimaryKey(ProxyMonitor record);
}