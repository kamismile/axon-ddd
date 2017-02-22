/**
 * http://usejsdoc.org/
 */
var webpack = require('webpack'); 
var path = require('path');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: [
	    'webpack/hot/dev-server',
	    'webpack-dev-server/client?http://localhost:3000',
	    './src/main/resources/static/app/index.js'      //入口文件
	    ],  
  output: {
    path: path.resolve('./src/main/resources/static', 'dist'),  // 指定编译后的代码位置为 dist/bundle.js
    filename: 'bundle.js'
  },
  module: {
    loaders: [
      // 为webpack指定loaders
      //{ test: /\.js$/, loaders: ['babel'], exclude: /node_modules/ }   
    ]
  },
  plugins: [
	  new HtmlWebpackPlugin({
	    title: 'React Biolerplate by Linghucong'
	  })
	]
};
