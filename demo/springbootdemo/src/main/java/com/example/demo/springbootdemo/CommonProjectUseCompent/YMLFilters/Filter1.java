package com.example.demo.springbootdemo.CommonProjectUseCompent.YMLFilters;

public class Filter1 implements FilterInterFace{

    @Override
    public void dofilter(FilterChainContext context, FilterChain chain) throws FilterChainException {

        chain.execute(context);

    }
}
