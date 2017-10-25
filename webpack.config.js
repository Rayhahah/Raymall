/**
 * Created by leizh on 2017/10/25.
 */
//获取目录路径
const path = require('path');
//获取webpack对象
var webpack = require('webpack');
//css单独打包
var ExtractTextPlugin = require("extract-text-webpack-plugin");
//html打包
var HtmlWebpackPlugin = require('html-webpack-plugin');

// 环境变量配置，dev / online
var WEBPACK_ENV = process.env.WEBPACK_ENV || 'dev';
//根据名字获取Html-webpack-plugin参数配置
var getHtmlConfig = function (name) {
    return {
        //html的原始模板
        template: './src/main/webapp/view/' + name + '.html',
        //文件输出目录
        filename: 'view/' + name + '.html',
        //true的话就可以不用手写js和css的引入
        inject: true,
        //会在js和css后面加入版本号
        hash: true,
        //不配置的话，默认会把全部chunks都打包进来
        chunks: ['common', name]
    }
};
var config = {
    //这样只能配置一个入口文件
    // entry: './src/app.js',
    //配置多个入口
    entry: {
        //配置webpack-dev-server
        'common': ['./src/main/webapp/page/common/index.js'],
        'index': ['./src/main/webapp/page/index/index.js'],
        'login': ['./src/main/webapp/page/login/index.js']
    },
    output: {
        //文件生成的路径
        //这个和下面是一样的意思
        // path:'./dist',
        path: path.resolve(__dirname, 'dist'),
        //文件访问的路径,不设置的话webpack-dev-server无法热编译
        publicPath: '/dist',
        //硬编码目标文件无法做到输出多个文件
        // filename: 'app.js'
        //这样就会根据入口的名字来对应生成目标文件，ps：webpack不会删除之前的文件
        filename: 'js/[name].js'
    },
    externals: {
        'jquery': 'window.jQuery'
    },
    module: {
        loaders: [
            //探测到css结尾的，就用css-loader处理，顺序是css-loader处理的结果再给style-loader
            {test: /\.css$/, loader: ExtractTextPlugin.extract("style-loader", "css-loader")},
            //探测所有图片资源，limit的作用是当大小小于100则会打成base64，否则就会放到资源文件夹里面
            //指定名字并且保留扩展名
            {test: /\.(gif|png|jpg|woff|svg|ttf|eot)\??.*$/, loader: 'url-loader?limit=100&name=resource/[name].[ext]'}
        ]
    },
    plugins: [
        //独立通用模块到js/base.js
        new webpack.optimize.CommonsChunkPlugin({
            //引用的名字,与上面的common对应，形成全局的公共模块
            name: 'common',
            //输出的名字
            filename: 'js/base.js'
        }),
        //css单独打包到文件里
        new ExtractTextPlugin("css/[name].css"),
        //项目模板参数
        new HtmlWebpackPlugin(getHtmlConfig('index')),
        new HtmlWebpackPlugin(getHtmlConfig('login'))
    ]
};
if ('dev' === WEBPACK_ENV) {
    config.entry.common.push('webpack-dev-server/client?http://localhost:8088/');
}

//输出配置
module.exports = config;