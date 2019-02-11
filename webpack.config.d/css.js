const path = require('path');
const jsPath = path.resolve(__dirname,'js');

config.entry.jsPath = path.resolve(jsPath,'style.js');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

config.plugins.push(new MiniCssExtractPlugin({
                          // Options similar to the same options in webpackOptions.output
                          // both options are optional
                          filename: "styles.css"
                        }));
config.module.rules.push({
                  test: /\.(sa|sc|c)ss$/,
                  use: [
                    MiniCssExtractPlugin.loader,
                    'css-loader',
                    {
                        loader:'postcss-loader',
                        options: {
                                     options: {},
                                   }
                    },
                    'sass-loader',
                  ]
                });