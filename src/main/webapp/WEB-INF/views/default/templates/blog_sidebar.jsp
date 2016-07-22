<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/inc.jspf"%>
<!-- Blog Search Well -->
<div class="well">
    <h4>블로그 검색</h4>
    <form action="/page/index" method="get" class="form-inline">
        <div class="input-group">
            <input type="text" class="form-control"
                   name="q" value="">
            <span class="input-group-btn">
                <button class="btn btn-default" type="submit">
                <span class="glyphicon glyphicon-search"></span>
            </button>
            </span>

        </div>
    </form>
    <!-- /.input-group -->
</div>

<!-- Blog Categories Well -->
<div class="well">
    <h4>블로그 카테고리</h4>
    
    
        
            
                <ul class="list_outer">
            
        

        <li>
            <i class="fa fa-angle-double-right"></i>
            <a href="/page/category/Flask">
                Flask
            </a>
            
                
    
        
            
                <ul class="list">
            
        

        <li>
            <i class="fa fa-angle-double-right"></i>
            <a href="/page/category/depth1">
                depth1
            </a>
            
                
    
        
            
                <ul class="list">
            
        

        <li>
            <i class="fa fa-angle-double-right"></i>
            <a href="/page/category/depth2">
                depth2
            </a>
            
        </li>

        </ul>
    
            
        </li>

        </ul>
    
            
        </li>

        </ul>
    
</div>

<!-- Side Widget Well -->
<div class="well">
    <h4>블로그 최근 게시물</h4>
    <ul class="list_outer">
        
            <li><a href="/page/tttt"><i class="fa fa-angle-double-right"></i> tttt</a></li>
        
            <li><a href="/page/%EB%B8%94%EB%A1%9C%EA%B7%B8-%EC%86%8C%EA%B0%9C"><i class="fa fa-angle-double-right"></i> 블로그 소개</a></li>
        
            <li><a href="/page/markdown"><i class="fa fa-angle-double-right"></i> markdown</a></li>
        
            <li><a href="/page/ddd"><i class="fa fa-angle-double-right"></i> ddd</a></li>
        
            <li><a href="/page/test"><i class="fa fa-angle-double-right"></i> test</a></li>
        
    </ul>
</div>

<div class="well">
    <h4>블로그 최근 댓글</h4>
    <ul class="list_outer">
        
    </ul>
</div>

<div class="well">
    <h4>블로그 태그</h4>
    <p>
       
           <a href="/page/tag/Flask" class="btn btn-sm btn-default spacer-bottom-10">Flask <span class="badge">1</span></a>
       
           <a href="/page/tag/Rabiang" class="btn btn-sm btn-default spacer-bottom-10">Rabiang <span class="badge">1</span></a>
       
           <a href="/page/tag/test" class="btn btn-sm btn-default spacer-bottom-10">test <span class="badge">1</span></a>
       
           <a href="/page/tag/ttt" class="btn btn-sm btn-default spacer-bottom-10">ttt <span class="badge">1</span></a>
       
    </p>
</div>

<div class="well">
    <h4>블로그 글보관함</h4>
    <ul class="list_outer">
        
            <li><a href="/page/month/2016/7"><i class="fa fa-angle-double-right"></i> 2016년 7월</a></li>
        
    </ul>
</div>
